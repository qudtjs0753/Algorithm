package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo14502 {
    static int N, M, max = 0, safeZone = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] map;
    static ArrayList<Coordination> virus = new ArrayList<>();
    private static class Coordination {
        int y, x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new Coordination(i, j));
                }else if(map[i][j]==0){
                    safeZone++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    createWall(1, i, j);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(max);
    }

    private static void createWall(int depth, int y, int x) {
        if (depth == 3){
            bfs();
            return;
        }

        for (int i = y; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i==y && j<x)continue;
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    createWall(depth + 1, i, j);
                    map[i][j] = 0;
                }
            }
        }
    }
    private static void bfs(){
        int count = safeZone;
        boolean[][] visited = new boolean[N][M];
        Queue<Coordination> q = new ArrayDeque<>();

        for(Coordination virusPos : virus){
            q.add(virusPos);
            visited[virusPos.y][virusPos.x] = true;
        }

        while (!q.isEmpty()) {
            Coordination current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx<0 || ny<0 || nx>=M || ny>=N || visited[ny][nx] || map[ny][nx]==1)continue;
                visited[ny][nx] = true;
                count--;
                q.add(new Coordination(ny, nx));
            }
        }
        max = Math.max(count-3, max);
    }

}
