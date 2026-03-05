package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1012 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int T,M,N,K, cabbageSetCount;
    static boolean[][] map,visited;

    private static class Coordination {
        int x,y;

        public Coordination(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }
            cabbageSetCount = 0;

            for(int i=0; i<N;i++){
                for(int j=0; j<M; j++){
                    if(!visited[i][j] && map[i][j])countCabbageSet(i,j);
                }
            }

            sb.append(cabbageSetCount).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void countCabbageSet(int y, int x) {
        //주변 bfs로 탐색
        //만약 1있으면 한묶음
        //1없으면 다음 묶음으로.
        Queue<Coordination> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Coordination(y,x));
        cabbageSetCount++;

        while(!q.isEmpty()){
            Coordination current = q.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if(nx>=0 && nx<M &&
                ny>=0 && ny<N &&
                map[ny][nx] && !visited[ny][nx]){
                    q.add(new Coordination(ny,nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }
}
