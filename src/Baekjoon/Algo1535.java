package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1535 {
    static int N;
    static int[] hp, happy;
    static int[][] memo;
    static final int MAX_HP = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        hp = new int[N+1];
        happy = new int[N+1];
        memo = new int[N+1][MAX_HP+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            happy[i] = Integer.parseInt(st.nextToken());
        }

        dp();
        System.out.println(memo[N][100]);
    }

    private static void dp() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<=MAX_HP; j++){
                if(j-hp[i]>0){
                    memo[i][j] = Math.max(memo[i-1][j-hp[i]] + happy[i], memo[i-1][j]);
                }
                else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
    }


}
