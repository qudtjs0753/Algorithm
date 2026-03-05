package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1719 {

    private static StringBuilder sb = new StringBuilder();
    private static int N,M;
    private static final int MAX = 10_000_001;
    private static int[][] dist, firstMet;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                if(i==k) continue;
                for(int j=1; j<=N; j++) {
                    int newDist = dist[i][k] + dist[k][j];
                    if(newDist<dist[i][j]) {
                        dist[i][j] = newDist;
                        firstMet[i][j] = firstMet[i][k];
                    }
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) sb.append("- ");
                else sb.append(firstMet[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];
        firstMet = new int[N+1][N+1];
        for(int i=0; i<=N; i++) {
            Arrays.fill(dist[i], 10000*1000 + 1);
        }

        for(int i=1; i<=N; i++) {
            dist[i][i] = 0;
            firstMet[i][i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            dist[v1][v2] = distance;
            dist[v2][v1] = distance;
            firstMet[v1][v2] = v2;
            firstMet[v2][v1] = v1;
        }
    }
}
