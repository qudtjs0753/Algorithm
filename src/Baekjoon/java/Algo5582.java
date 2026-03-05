package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo5582 {
    static String a, b;
    static int[][] dp;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        dp= new int[a.length()+1][b.length()+1];

        for(int i=1; i<a.length()+1; i++){
            for(int j=1; j<b.length()+1; j++) {
                if (a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max);

    }
}
