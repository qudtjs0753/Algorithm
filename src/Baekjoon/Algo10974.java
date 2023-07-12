package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo10974 {
    static int N;
    static int[] arr;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        dfs(0);
    }

    private static void dfs(int depth) {
        if(depth==N) {
            for(int i=0; i<N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            arr[depth] = i;
            dfs(depth+1);
            visit[i] =false;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        arr = new int[N];
    }
}
