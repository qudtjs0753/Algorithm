package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo5547 {
    private static class Coordination {
        int y, x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int W,H, wallLength=0;
    static int[] dxOdd = {-1, 0, 1, 1, 1, 0};
    static int[] dy = {0, -1, -1, 0, 1, 1};
    static int[] dxEven = {-1,-1, 0 , 1, 0, -1};
    static boolean[][] visited;
    static int[][] map;
    static Queue<Coordination> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+2][W+2];
        visited = new boolean[H+2][W+2];
        for(int i=0; i<=H+1; i++) Arrays.fill(map[i], 2);
        for(int i=1; i<=H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    q.add(new Coordination(i,j));
                }
            }
        }

        //외부확인.
        findOutDoor();

        //벽 길이 체크.
        bfs();

        System.out.println(wallLength);
    }

    private static void findOutDoor() {
        for(int i=1; i<=H; i++){
            if(map[i][1]==0 && !visited[i][1]){
                visited[i][1] = true;
                checkIsOutDoor(i,1);
            }
            if(map[i][W]==0 && !visited[i][W]){
                visited[i][W] = true;
                checkIsOutDoor(i,W);
            }
        }

        for(int i=1; i<=W; i++){
            if(map[1][i]==0 && !visited[1][i]){
                visited[1][i] = true;
                checkIsOutDoor(1,i);
            }
            if(map[H][i]==0 && !visited[H][i]){
                visited[H][i] = true;
                checkIsOutDoor(H,i);
            }
        }

    }

    private static void bfs() {
        while(!q.isEmpty()){
            Coordination current = q.poll();

            for(int i=0; i<6; i++){
                int nx, ny;
                if(current.y%2==1){
                    nx = current.x + dxOdd[i];
                }else{
                    nx = current.x + dxEven[i];
                }
                ny = current.y + dy[i];

                if((map[ny][nx]==0 && visited[ny][nx]) || map[ny][nx]==2){
                    wallLength++;
                }

            }
        }
    }

    private static void checkIsOutDoor(int y, int x){
        Queue<Coordination> noStructure = new ArrayDeque<>();
        noStructure.add(new Coordination(y, x));
        while(!noStructure.isEmpty()){
            Coordination current = noStructure.poll();

            for(int i=0; i<6; i++){
                int nx, ny;
                if(current.y%2==1){
                    nx = current.x + dxOdd[i];
                }else{
                    nx = current.x + dxEven[i];
                }
                ny = current.y + dy[i];

                if(!visited[ny][nx] && map[ny][nx]==0){
                    noStructure.add(new Coordination(ny,nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }


}
