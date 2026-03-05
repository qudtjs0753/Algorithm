package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2098_Solution {
    static int N,visitAll,answer;
    static int[][] dp,weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visitAll = (1 << N) - 1;

        dp = new int[N+1][visitAll + 1];
        weight = new int[N+1][N+1];
        answer = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);

        dp[1][1] = 0;

        traverlingRoute(1,1);


        System.out.println(answer);
    }

    public static void traverlingRoute(int current, int visited){
        //기저사례
        //모든 도시를 방문한 경우
        //마지막 도시로 다시 돌아오는 부분. 여기서 좀 어려웠다.
        if(visited==visitAll){
            if(weight[current][1] == 0){
                return;
            }
            answer = Math.min(answer, dp[current][visited] + weight[current][1]);
            return;
        }


        for(int i=1; i<=N; i++){
            //저장.
            int next = (1<<i-1);

            //여기부터 핵심.
            int nextVisit = next | visited;

            if(nextVisit==visited)continue;

            if(weight[current][i]==0)continue;

            if(dp[i][nextVisit] > dp[current][visited] + weight[current][i]){
                dp[i][nextVisit] = dp[current][visited] + weight[current][i];
                traverlingRoute(i, nextVisit);
            }
        }
    }

}
