package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo14728 {
    static int N, T;
    static int[] memo;
    static int[][] chapters;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        memo = new int[T+1];
        chapters = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            chapters[i][0] = Integer.parseInt(st.nextToken());
            chapters[i][1] = Integer.parseInt(st.nextToken());
        }
        memoization();

        System.out.println(memo[T]);
    }

    private static void memoization() {

        for(int i=0; i<N; i++){
            for(int j=T; j>=0; j--){
                if(j-chapters[i][0] >= 0){
                    memo[j] = Math.max(memo[j-chapters[i][0]] + chapters[i][1], memo[j]);
                }
            }
        }
    }
}
