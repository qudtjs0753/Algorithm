package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo12865 {
    static int N, K;
    static Thing[] things;
    static int[][] dp;
    public static class Thing {
        int weight, value;
        Thing(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

    }
    public static int findKnapsack(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(things[i].weight > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-things[i].weight]+things[i].value, dp[i-1][j]);
                }
            }
        }

        return dp[N][K];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        things = new Thing[N+1];
        dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            things[i] = new Thing(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()));
        }

        System.out.println(findKnapsack());
    }
}
