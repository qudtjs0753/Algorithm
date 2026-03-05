package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo9252 {
    static String a, b;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        a = br.readLine();
        b = br.readLine();
        dp= new int[a.length()+1][b.length()+1];

        for(int i=1; i<a.length()+1; i++){
            for(int j=1; j<b.length()+1; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        int row = a.length();
        int column = b.length();

        while(row>=1 && column>=1){
            if(dp[row][column]==dp[row-1][column]){
                row--;
            }else if(dp[row][column]==dp[row][column-1]){
                column--;
            }else{
                sb.append(a.charAt(row-1));
                row--;
                column--;
            }
        }


        if(sb.length()!=0){
            System.out.println(dp[a.length()][b.length()]);
            System.out.println(sb.reverse());
        }else{
            System.out.println(dp[a.length()][b.length()]);
        }

    }
}
