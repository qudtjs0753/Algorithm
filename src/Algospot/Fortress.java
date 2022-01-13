package Algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
class Wall {
    int x, y, radius;
    ArrayList<Wall> child;
    Wall(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.child = new ArrayList<>();
    }
}

public class Fortress {
    static int C, N, longest;
    static Wall[] arr;
    public static int solve(Wall root){
        longest = 0;
        int h = height(root);

        //이거 비교할 필요 없는거 아닌가요? 왜 해야하죠?
        //height.size(). 즉 자식의 개수가 2개 이상이 아닌경우 longest에 대입을 안시킴.
        //그런경우에는 그냥 height으로 함.
        return Math.max(longest, h);
    }

    public static int height(Wall root){
        ArrayList<Integer> heights = new ArrayList<>();
        for(int i=0; i < root.child.size(); i++)
            heights.add(height(root.child.get(i)));
        if(heights.isEmpty()) return 0;
        Collections.sort(heights);

        //여기에 왜 2를 더하죠?
        //루트의 아래 서브루트까지의 길이를 구하는 것이므로.
        //루트로 가는 경로 각각 하나씩 더해주는 것이다.
        if((heights.size()>=2))
            longest = Math.max(longest, 2 + heights.get(heights.size()-2) + heights.get(heights.size()-1));

        //트리 높이. 서브트리의 높이 + 1(root)
        return heights.get(heights.size()-1)+1;
    }

    public static Wall createTree(Wall root){
        Wall ret = root;
        for(int idx = 0; idx<N; idx++){
            if(isChild(root, arr[idx]))
                ret.child.add(createTree(arr[idx]));
        }

        return ret;
    }

    public static boolean isChild(Wall parent, Wall child){
        //parent는 child를 '직접' 포함해야한다.
        if(!encloses(parent,child)) return false;
        for(int i = 0; i<N; i++){
            if(arr[i] != parent && arr[i]!=child &&
                encloses(parent, arr[i]) && encloses(arr[i], child))
                return false;
        }
        return true;
    }
    public static boolean encloses(Wall wall1, Wall wall2){
        return wall1.radius > wall2.radius &&
                squareDistance(wall1, wall2) < square(wall1.radius - wall2.radius);
    }
    public static int square(int x){return x*x;}

    public static int squareDistance(Wall wall1, Wall wall2){
        return square(wall1.x - wall2.x) + square(wall1.y-wall2.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        while(C>0){
            N = Integer.parseInt(br.readLine());
            arr = new Wall[N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = new Wall(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }
            createTree(arr[0]);
            System.out.println(solve(arr[0]));
            C--;
        }
    }
}
