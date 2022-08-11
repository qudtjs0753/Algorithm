package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo7579 {
    static int N,M, minValue=Integer.MAX_VALUE, allCost = 0;
    static int[][] memo;
    static int[] memory, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N+1];
        cost  =new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            allCost+=cost[i];
        }
        memo = new int[N+1][allCost+1];

        memoization();

        System.out.println(minValue);
    }

    private static void memoization() {
        for(int i=1; i<=N; i++){
            for(int j=0; j<=allCost; j++){
                if(j-cost[i]>=0)
                    memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-cost[i]] + memory[i]);
                else
                    memo[i][j] = memo[i-1][j];


                if(memo[i][j]>=M){
                    minValue = Math.min(j, minValue);
                }
            }
        }
    }
}
