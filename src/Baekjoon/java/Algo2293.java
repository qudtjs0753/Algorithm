package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2293 {
    static int N,K;
    static int[] memo, coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        memo =new int[K+1];
        memo[0] = 1;
        coins = new int[N];
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++){
            for(int j=1; j<=K; j++){
                if(j-coins[i]>=0 && memo[j-coins[i]]!=0)
                    memo[j] += memo[j-coins[i]];
            }
        }

        System.out.println(memo[K]);
    }
}
