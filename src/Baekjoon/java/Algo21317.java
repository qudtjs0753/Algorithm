package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo21317 {
    static int N,K;
    static int[][] memo;
    static int[][] jump;
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        memo = new int[2][21];
        jump = new int[2][21];
        Arrays.fill(memo[0], MAX);
        Arrays.fill(memo[1], MAX);
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            jump[0][i] = Integer.parseInt(st.nextToken());
            jump[1][i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());
        memo[0][0] = 0;
        memo[1][0] = 0;
        memo[0][1] = jump[0][0];
        memo[1][1] = jump[0][0];
        memo[0][2] = Math.min(jump[0][0]+jump[0][1], jump[1][0]);
        memo[1][2] = Math.min(jump[0][0]+jump[0][1], jump[1][0]);

        for(int i=3; i<=N-1; i++){
            memo[0][i] = Math.min(memo[0][i-2] + jump[1][i-2],Math.min(memo[0][i], memo[0][i-1] + jump[0][i-1]));
            memo[1][i] = Math.min(memo[1][i-2] + jump[1][i-2],Math.min(memo[1][i], memo[1][i-1] + jump[0][i-1]));
            memo[1][i] = Math.min(memo[1][i], memo[0][i-3] + K);
        }

        System.out.println(Math.min(memo[1][N-1],memo[0][N-1]));
    }
}
