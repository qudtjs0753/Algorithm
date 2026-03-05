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
public class Algo2206 {
    static int N,M;
    static int[][] map;
    static boolean[][][] visit;
    static int[][] dist;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    private static class Coordination {
        int x, y;
        int crash;

        public Coordination(int y, int x, int crash) {
            this.x = x;
            this.y = y;
            this.crash= crash;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dist = new int[N+1][M+1];
        visit = new boolean[2][N+1][M+1];

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = str.charAt(j-1)-'0';
            }
        }


        System.out.println(bfs());
    }

    private static int bfs(){
        if(N==1 && M==1) return 1;

        Queue<Coordination> q = new LinkedList<>();
        q.add(new Coordination(1, 1, 0));

        while(!q.isEmpty()){
            Coordination current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx<1 || nx>M || ny<1 || ny>N){
                    continue;
                }

                if(map[ny][nx]==1){
                    if(current.crash==0 && !visit[1][ny][nx]){
                        visit[0][ny][nx] = true;
                        dist[ny][nx] = dist[current.y][current.x] + 1;
                        q.add(new Coordination(ny, nx, 1));
                    }
                }

                else {
                    if(!visit[current.crash][ny][nx]){
                        visit[current.crash][ny][nx] = true;
                        dist[ny][nx] = dist[current.y][current.x] + 1;
                        q.add(new Coordination(ny, nx, current.crash));
                    }
                }

                if(ny == N && nx == M){
                    return dist[ny][nx] + 1;
                }
            }
        }
        return -1;

    }
}
