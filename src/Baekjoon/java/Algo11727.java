package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo11727 {
    static int N;
    static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new long[N];

        memo[0] = 1;
        memo[1] = 3;
        for(int i=2; i<N; i++){
            memo[i] = (memo[i-1] + memo[i-2]*2)%10007;
        }

        System.out.println(memo[N-1]%10007);
    }
}
