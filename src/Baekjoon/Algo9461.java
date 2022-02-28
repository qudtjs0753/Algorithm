package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo9461 {
    static long[] memo = new long[101];
    static int T,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        dp();
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            sb.append(memo[N]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dp() {
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;

        for(int i=4; i<=100; i++){
            memo[i] = memo[i-2] + memo[i-3];
        }
    }
}
