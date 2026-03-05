package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1010 {
    static int N, M,T;
    static long[][] dp;
    static final int DIVISOR = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new long[M+1][N+1];

            System.out.println(combination(M,N));
        }
    }

    public static long combination(int n, int r){
        if(n==r || r==0)return dp[n][r] = 1;
        else if(dp[n][r]!=0){
            return dp[n][r];
        }else{
            return dp[n][r] = (combination(n-1,r-1) + combination(n-1,r));
        }
    }
}
