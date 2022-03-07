package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo17626 {
    static int N;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bigNum = 1;
        N = Integer.parseInt(br.readLine());

        memo = new int[50001];
        for(int i=0; i<=N; i++){
            memo[i] = 500000;
        }
        memo[0] = 0;
        memo[1] = 1;

        for(int i=2; i<=N; i++){
            for(int j=1; j*j<=i; j++){
                memo[i] = Math.min(memo[i-j*j]+1, memo[i]);
            }
        }

        System.out.println(memo[N]);
    }
}
