package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2247 {

    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        long answer = 0;


        for (long i = 2; i < N; i++) {
            answer += (N / i - 1) * i % 1_000_000;
            answer %= 1_000_000;
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
}
