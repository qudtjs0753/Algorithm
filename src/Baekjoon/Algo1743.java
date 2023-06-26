package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1743 {

    static int N,M,K;
    static int[][] map;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static boolean[][] visit;

    static int maximum = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1][v2] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j]==1 && !visit[i][j]) {
                    visit[i][j] = true;
                    bfs(i,j);
                }
            }
        }

        System.out.println(maximum);
    }

    private static void bfs(int startY, int startX) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startY,startX});
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            cnt++;
            for(int i=0; i<4; i++) {
                int ny = current[0] +  dy[i];
                int nx = current[1] +  dx[i];

                if(isInvalid(ny,nx) || visit[ny][nx] || map[ny][nx]==0) continue;
                q.add(new int[]{ny,nx});
                visit[ny][nx] = true;
            }
        }

        maximum = Math.max(maximum,cnt);
    }

    private static boolean isInvalid(int ny, int nx) {
        return ny<=0 || ny>N || nx<=0 || nx>M;
    }
}
