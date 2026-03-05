package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo10844 {
    static int N;
    static long[][] dp;
    static boolean[][] visited = new boolean[10][100];
    public static long findStairNum(int num,int index){
        //기저사례
        if(num<0 || num>9)return 0;
        if(index==0){
            visited[num][index] = true;
            return dp[num][index];
        }

        //memoization
        if(!visited[num][index]){
            visited[num][index] = true;
            dp[num][index] = (findStairNum(num-1, index-1) + findStairNum(num+1,index-1))%1000000000;
        }

        return dp[num][index];
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[10][100];
        for(int i=0;i<10; i++){
            for(int j=0; j<100; j++)dp[i][j] = 1;
        }
        long result=0;
        for(int i=1; i<10; i++){
            result += findStairNum(i, N-1);
        }
        System.out.println(result%1000000000);
    }
}
