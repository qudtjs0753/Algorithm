package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1520 {

    static int N,M;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int[][] memo;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        System.out.println(memoization(0,0));
    }

    private static int memoization(int y, int x) {
        if(memo[y][x]!=-1) return memo[y][x];


        memo[y][x] = 0;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(isInvalid(ny,nx) || map[ny][nx]>=map[y][x])continue;
            memo[y][x] += memoization(ny,nx);
        }
        return memo[y][x];
    }

    private static boolean isInvalid(int ny, int nx) {
        return ny<0 || ny>=N || nx<0 || nx>=M;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        memo = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<N; i++) {
            Arrays.fill(memo[i],-1);
        }

        memo[N-1][M-1] = 1;
    }
}
