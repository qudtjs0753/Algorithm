package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1300 {
    static long N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        System.out.println(parametricSearch())  ;
    }

    private static long parametricSearch() {
        long lo = 0, hi = K;

        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;

            if (calculate(mid) < K) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    private static long calculate(long mid) {
        long count = 0;

        for (int i = 1; i <= N; i++) {
            count += Math.min(mid / i, N);
        }
        return count;
    }
}
