package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo15486 {
    static int[][] consult = new int[2][1500051];
    static int[] memo;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        memo = new int[N+2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            consult[0][i] = Integer.parseInt(st.nextToken());
            consult[1][i] = Integer.parseInt(st.nextToken());

        }

        for(int i=N; i>=1; i--){
            if(consult[0][i] + i > N+1){
                memo[i] = memo[i+1];
            }else{
                memo[i] = Math.max(memo[i+1], memo[i+consult[0][i]] + consult[1][i]);
            }
        }
        System.out.println(memo[1]);
    }
}
