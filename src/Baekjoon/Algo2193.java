package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo2193 {
    static int N;
    static long[] memo = new long[90];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp();

        System.out.println(memo[N-1]);
    }

    private static void dp(){
        memo[0] = 1; memo[1]=1;

        for(int i=2; i<N; i++){
            for(int j=0; j<i-1; j++){
                memo[i] += memo[j];
            }
            memo[i]+=1;
        }
    }
}
