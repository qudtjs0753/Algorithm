package Baekjoon;

import java.io.*;

public class Algo9251 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String b = br.readLine();
        int lengthA = a.length();
        int lengthB = b.length();
        dp = new int[lengthA+1][lengthB+1];
        int maxlength = 0;
        //LCS
        for(int i=1; i<lengthA+1; i++){
            for(int j=1; j<lengthB+1; j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxlength = Math.max(maxlength, dp[i][j]);
            }
        }
        bw.write(String.valueOf(maxlength));
        bw.flush();
        bw.close();
    }
}
