package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11051 {
    static int N, K;
    static int[][] dp;
    static final int DIVISOR = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];

        System.out.println(combinateWithMod(N,K));
    }

    public static int combinateWithMod(int n,int r){
        if(n==r || r==0)return dp[n][r] = 1;
        else if(dp[n][r]!=0){
            return dp[n][r];
        }else{
            return dp[n][r] = (combinateWithMod(n-1,r-1) + combinateWithMod(n-1,r))%DIVISOR;
        }
    }
}
