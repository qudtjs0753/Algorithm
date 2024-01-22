package Baekjoon;

import java.io.*;

public class Algo2217 {

    static int[] arr = new int[10001];

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        int cnt = 0;
        int max = 0;
        for(int i=10000; i>0; i--) {
            cnt+=arr[i];
            max = Math.max(cnt*i, max);
        }

        System.out.println(max);
    }
}
