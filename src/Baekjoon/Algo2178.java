package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2178 {
    static int N,M;
    static int[][] map,depth;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Coordination {
        int x, y;

        public Coordination(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        depth = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String input = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
        findMinDistance();
        System.out.println(depth[N][M]);
    }

    private static void findMinDistance(){
        Queue<Coordination> q = new LinkedList<>();
        depth[1][1] = 1;
        q.add(new Coordination(1,1));
        while(!q.isEmpty()){
            Coordination current = q.poll();
            int nx,ny;
            for(int i=0; i<4; i++){
                nx = current.x+dx[i];
                ny = current.y+dy[i];
                if(nx>=1 && nx<=M &&
                        ny>=1 && ny<=N &&
                        map[ny][nx]==1 && depth[ny][nx]==0
                ){
                    depth[ny][nx] = depth[current.y][current.x]+1;
                    q.add(new Coordination(ny, nx));
                }
            }
        }

    }
}
