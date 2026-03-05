package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo15990 {

    static final int MAX = 1_000_000_009;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] memo = new int[100_001][4];

        //초기화
        memo[1][1] = 1;memo[2][2] = 1;
        memo[3][1] = 1; memo[3][2] = 1; memo[3][3] = 1;
        for(int i=4; i<=100_000; i++) {
            for(int j=1; j<=3; j++) {
                for(int k=1; k<=3; k++) {
                    if(j==k) continue;
                    memo[i][j] =(memo[i][j] + memo[i-j][k])%MAX;
                }
            }
        }

        for(int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int result = ((memo[N][1] + memo[N][2])%MAX + memo[N][3])%MAX;

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
