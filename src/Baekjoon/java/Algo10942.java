package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */


public class Algo10942 {
    static int N,M;
    static int[] num;
    static boolean[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N+1];
        memo = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        memoization();
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            if(memo[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void memoization() {
        //1개
        for(int i=1; i<=N; i++){
            memo[i][i] =  true;
        }

        //2개
        for(int i=1; i<=N-1; i++){
            if(num[i] == num[i+1])memo[i][i+1] = true;
        }

        //3개부터
        for(int i=2; i<N; i++){
            for(int j=1; j<=N-i; j++){
                if(memo[j+1][j+i-1] && num[j] == num[j+i]){
                    memo[j][j+i] = true;
                }
            }
        }
    }
}
