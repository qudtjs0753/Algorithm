package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1562 {

    static final int MAX_NUMBER = 1 << 10;
    static final int MOD = 1_000_000_000;
    static long[][][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new long[N + 1][10][MAX_NUMBER];

        for (int i = 1; i <= 9; i++) {
            memo[1][i][1 << i] = 1;
        }

        for (int length = 2; length <= N; length++) {
            for (int lastNum = 0; lastNum <= 9; lastNum++) {
                for (int visit = 0; visit < MAX_NUMBER; visit++) {
                    int currentVisit = (1 << lastNum) | visit;
                    if (lastNum == 9) {
                        memo[length][lastNum][currentVisit] += memo[length - 1][lastNum - 1][visit];
                    } else if (lastNum == 0) {
                        memo[length][lastNum][currentVisit] += memo[length - 1][lastNum + 1][visit];
                    } else {
                        memo[length][lastNum][currentVisit] +=
                                (memo[length - 1][lastNum - 1][visit] + memo[length - 1][lastNum + 1][visit]) % MOD;
                    }
                    memo[length][lastNum][currentVisit] %= MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + memo[N][i][(1 << 10) - 1]) % MOD;
        }
        System.out.println(result);
    }
}
