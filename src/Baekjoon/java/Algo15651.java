package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo15651 {

    static int N,M;
    static int[] arr;
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
        if(depth==M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            arr[depth] = i;
            dfs(depth+1);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
    }
}
