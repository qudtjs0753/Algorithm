package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2098 {
    static int N,visitAll;
    static int[][] dp,weight;
    static final int INF = 16000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visitAll = (1 << N) - 1;

        dp = new int[N+1][visitAll + 1];
        weight = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<=N; i++)
                Arrays.fill(dp[i], INF);

        System.out.println( travelingRoute(1,1));
    }

    public static int travelingRoute(int current, int visited) {

        //기저사례 1. 모든 도시를 한번씩 다 돈 겨우.
        if (visited == visitAll) { // base case
            if (weight[current][1] == 0)
                return INF;
            return weight[current][1];
        }

        //기저사례 2. dp의 최적화가 끝난 경로를 다시 돌게 되는 경우.
        if (dp[current][visited] != INF) {
            return dp[current][visited];
        }

        //3. 경로에 대한 dp의 최적화가 이루어져야 하는 경우.
        for (int i = 1; i <= N; i++) {
            int next = (1 << i-1);
            int nextVisit = next | visited;
            if ((visited & next) == 0 && weight[current][i] != 0) {
                dp[current][visited] = Math.min(dp[current][visited], travelingRoute(i, nextVisit) + weight[current][i]);
            }
        }

        return dp[current][visited];
    }
}
