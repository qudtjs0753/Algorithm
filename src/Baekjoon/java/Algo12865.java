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

        Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

    public static int findKnapsack(int kindOfThing, int k) {
        if (kindOfThing == N+1) return 0;

        if (dp[kindOfThing][k]!=-1) return dp[kindOfThing][k];

        if(k-things[kindOfThing].weight>=0) {
            dp[kindOfThing][k] = Math.max(
                    findKnapsack(kindOfThing+1,  k-things[kindOfThing].weight) + things[kindOfThing].value,
                    dp[kindOfThing][k]);
        }
        return dp[kindOfThing][k] = Math.max(findKnapsack(kindOfThing+1, k), dp[kindOfThing][k]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        things = new Thing[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            things[i] = new Thing(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()));
            Arrays.fill(dp[i],-1);
        }

        System.out.println(findKnapsack(1,  K));
    }
}
