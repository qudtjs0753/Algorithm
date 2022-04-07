package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2636 {
    static int rows, cols, remainCheese=0,cheeseCount,result=0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Coordination> q = new ArrayDeque<>();

    private static class Coordination {
        int y,x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        map = new int[rows+2][cols+2];
        visited = new boolean[rows+2][cols+2];

        for(int i=1; i<=rows; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=cols; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    remainCheese++;
                }
            }
        }

        while(remainCheese !=0){
            cheeseCount=remainCheese;
            findOutdoor();
            result++;
        }

        System.out.println(result);
        System.out.println(cheeseCount);
    }


    private static void findOutdoor() {
        visited = new boolean[rows+2][cols+2];
        q.add(new Coordination(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Coordination current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(ny<0 || ny>rows || nx<0 || nx>cols || visited[ny][nx])continue;
                if(map[ny][nx]==0){
                    q.add(new Coordination(ny,nx));
                }else if(map[ny][nx]==1){
                    remainCheese--;
                    map[ny][nx] = 0;
                }
                visited[ny][nx] = true;
            }
        }
    }
}
