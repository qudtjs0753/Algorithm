package Baekjoon;

import java.io.*;

public class Algo2579 {
    static int N;
    static int[] dp;
    static int[] arr;


    public static int stairs(int n){
        //dp[n] = dp[n-1] + dp[n-3] + arr[n];
        //dp[n] = dp[n-2] + arr[n];
        if(dp[n]==0)return dp[n] = Math.max(stairs(n-3) + arr[n-1], stairs(n-2)) + arr[n];
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[300];
        dp = new int[300];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1] + arr[0];
        dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);
        stairs(N-1);
        bw.write(String.valueOf(dp[N-1]));
        bw.flush();
        bw.close();
    }
}
