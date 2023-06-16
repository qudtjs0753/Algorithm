package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo11265 {
    static int[][] map;
    static int N,M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        floyd();
        result();
    }

    private static void result() throws IOException {
        StringTokenizer st = null;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if(map[v1][v2]<=Integer.parseInt(st.nextToken())) {
                sb.append("Enjoy other party").append("\n");
            }else {
                sb.append("Stay here").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void floyd() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                if(i==k) continue;
                for(int j=1; j<=N; j++) {
                    map[i][j] = Math.min(map[i][k]+ map[k][j], map[i][j]);
                }
            }
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
