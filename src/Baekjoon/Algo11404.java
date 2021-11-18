package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Algo11404 {
    static int N,M;
    static int[][] dp;
    static final int  MAX_DISTANCE = 10000001;
    public static void floyd(){
        for(int k=0; k<N;k++){
            for(int i=0; i<N; i++) {
                if (i != k){
                    for(int j= 0; j< N; j++){
                        if(j!=k&&j!=i)
                            dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N][N];
        int index1, index2;
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)dp[i][j] = MAX_DISTANCE;

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            index1 = Integer.parseInt(st.nextToken())-1;
            index2 = Integer.parseInt(st.nextToken())-1;
            dp[index1][index2] = Math.min(dp[index1][index2],Integer.parseInt(st.nextToken()));
        }
        floyd();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(dp[i][j]<MAX_DISTANCE)
                    bw.write(String.valueOf(dp[i][j] + " "));
                else
                    bw.write(String.valueOf(0) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
