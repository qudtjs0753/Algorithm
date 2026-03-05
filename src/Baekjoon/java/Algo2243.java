package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2243 {
    static int n;
    static int A,B,C, size;


    static int[] candies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        size = findSize();
        //부모 노드에는 가지고 있는 사탕의 종류 수를 담고
        //리프노드에 그 사탕들의 순위에 맞춰 개수를 저장.
        candies = new int[size*2];
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            if(A==2){
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                update(B, C);
            }
            if(A==1){
                B = Integer.parseInt(st.nextToken());
                sb.append(query(1, size, 1, B) + "\n");
            }
        }
        System.out.println(sb);
    }

    public static int findSize(){
        int size = 1;
        while(size<1000000)size*=2;
        return size;
    }


    public static void update(int flavor, int diff){
        int idx = flavor + size -1;
        candies[idx] += diff;

        while(idx>1){
            int parent = idx/2;
            candies[parent] = candies[parent*2] + candies[parent*2+1];
            idx = parent;
        }

    }
    public static int query(int left, int right, int node, int queryRank){
        //1. 찾은 경우.
        if(left==right) {
            candies[node] -=1;
            return left;
        }

        //2. 결정할 수 없는 경우
        //왼쪽을 확인했는데 순위가 오른쪽이 더 클때.
        int result;
        int mid = (left+right)/2;
        if(candies[node*2]>=queryRank){
            result =  query(left, mid, node*2, queryRank);
            candies[node] -=1;
        }
        else{
            result = query(mid+1, right, node*2+1,queryRank-candies[node*2]);
            candies[node] -=1;
        }
        return result;
    }
}
