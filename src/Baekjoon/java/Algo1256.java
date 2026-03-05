package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1256 {
    static int[][] dp;
    static int N,M,K;
    static final int MAX_K = 1000000000;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+M+1][M+1];

        if(combination(N+M, M)<K){
            System.out.println(-1);
            return;
        }
        findKthWord(N, M, K);
        System.out.println(sb);
    }

    static void findKthWord(int n, int m, long k){
        //기저사례
        if(n+m==0){
            return;
        }
        else if(n==0){
            sb.append('z');
            findKthWord(n,m-1,k);
        }else if(m==0){
            sb.append('a');
            findKthWord(n-1,m,k);
        }else{
            int left = combination(n+m-1, m);
            if(left>=k){
                sb.append('a');
                findKthWord(n-1,m,k);
            }else{
                sb.append('z');
                findKthWord(n,m-1,k-left);
            }
        }
        //끝에 도달한 경우.

    }
    static int combination(int n,int r){
        if(n==r || r==0)return 1;
        else if(dp[n][r] != 0){
            return dp[n][r];
        } else{
            return dp[n][r] = Math.min( MAX_K , combination(n-1,r-1) + combination(n-1,r));
        }
    }

}
