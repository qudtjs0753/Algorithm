package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1932 {
    static int N;
    static int[][] arr, dp;
    public static int maximumSum(){
        if(N==1) return arr[0][0];
        for(int i=N-2; i>=0; i--){
            for(int j=0; j<=i ;j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[500][500];
        dp = new int[500][500];


        for(int i=0; i<N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = arr[i][j];
                j++;
            }
        }

        System.out.println(maximumSum());
    }
}
