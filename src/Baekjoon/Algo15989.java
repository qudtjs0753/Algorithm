package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo15989 {

    static long[][] memo;
    static int T;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        memo = new long[10001][4];

        for (int i = 1; i <= 3; i++) {
            memo[i][i] = 1;
        }
        memo[2][1] = 1;
        memo[3][2] = 1;
        memo[3][1] = 1;

        memoization();

        for (int testCase = 0; testCase < T; testCase++) {
            int number = Integer.parseInt(br.readLine());
            long result = memo[number][3] + memo[number][2] + memo[number][1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void memoization() {
        for (int i = 4; i <= 10000; i++) {
            memo[i][3] = getIfValid(i-3, 3) +
                    getIfValid(i-3, 2) + getIfValid(i-3, 1);
            memo[i][2] = getIfValid(i-2, 2) + getIfValid(i-2, 1);
            memo[i][1] = getIfValid(i-1, 1);
        }
    }

    private static long getIfValid(int number, int maxNumber) {
        if(number<=0) return 0;

        return memo[number][maxNumber];
    }
}
