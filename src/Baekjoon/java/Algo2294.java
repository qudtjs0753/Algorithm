package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2294 {
    static int[] memo;
    static int N,K;
    static final int MAX = 1000000;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N+1];
        memo = new int[K+1];
        for(int i=1; i<=N; i++){
            coins[i] = Integer.parseInt(br.readLine());

        }
        Arrays.fill(memo, MAX);
        memo[0] = 0;
        for(int i=1; i<=N; i++){
            for(int j=0; j<=K; j++){
                if(j-coins[i]>=0){
                    memo[j] = Math.min(memo[j], memo[j-coins[i]]+1);
                }
            }
        }

        if(memo[K]==MAX) System.out.println(-1);
        else System.out.println(memo[K]);
    }
}
