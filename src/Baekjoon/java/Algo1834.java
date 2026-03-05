package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1834 {

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
        long N = Integer.parseInt(br.readLine());

        long result = 0;

        for(int i=1; i<N; i++) {
            result += N*i + i;
        }
        System.out.println(result);
    }
}
