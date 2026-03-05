package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2156 {
    static int n;
    static int[] arr;
    static int[] dp;
    public static int drinkMany(int index){
        //기저사례
        if(index>=n-1) return dp[index];
        if(dp[index]==0) return dp[index] = Math.max(Math.max(drinkMany(index+2),arr[index+1] + drinkMany(index+3)) + arr[index], drinkMany(index+1));
        return dp[index];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+4];
        dp = new int[n+4];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[n-1] = arr[n-1];
        if(n>1) dp[n-2] = arr[n-1] + arr[n-2];
        System.out.println( drinkMany(0));
    }
}
