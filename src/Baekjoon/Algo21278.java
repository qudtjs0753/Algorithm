package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo21278 {

    private static final int MAX = 10000;
    private static int N,M;
    static int[] ans = new int[3];
    static int[][] dist;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }

    private static void solve() {
        floyd();
        getMinimum();
    }

    private static void getMinimum() {
        for(int i=1; i<N; i++) {
            for(int j=i+1; j<=N; j++) {
                int calculateAllDistance = calculateDistance(i,j);
                if(calculateAllDistance<ans[2]) {
                    ans[2] = calculateAllDistance;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
    }

    private static int calculateDistance(int chicken1, int chicken2) {
        int ret = 0;
        for(int i=1; i<=N; i++) {
            ret += 2*Math.min(dist[chicken1][i], dist[chicken2][i]);
        }
        return ret;
    }

    private static void floyd() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                if(i==k)continue;
                for(int j=1; j<=N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];
        for(int i=0; i<=N; i++) {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
        }
        ans[2] = Integer.MAX_VALUE;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            dist[v1][v2] = 1;
            dist[v2][v1] = 1;
        }
    }
}
