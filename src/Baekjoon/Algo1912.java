package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1912 {
    static int N;
    static int[] dp, input;

    public static int largestSeqSum(){
        for(int i=1; i<N; i++){
            if(dp[i-1]<0);
            else{
                dp[i] = dp[i-1] + input[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = input[i];
        }
        System.out.println(largestSeqSum());
    }
}
