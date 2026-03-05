package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2565 {
    static int N,maxCount=1;
    static int[] dp = new int[501];
    static int[] lines = new int[501];
    public static void countRemainLine(){
        for(int i=0; i<501; i++){
            for(int j=0; j<i; j++){
                if(lines[i]>500)break;
                else if(lines[j]>500);
                else{
                    if(lines[i]>lines[j])
                        dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxCount = Math.max(dp[i], maxCount);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<501; i++){
            dp[i] = 1;
            lines[i] = 1000;
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        countRemainLine();
        System.out.println(N-maxCount);
    }
}
