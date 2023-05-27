package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo2688 {

    private static final int MAX_NUM = 64;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        long[][] memo = new long[65][10];
        for(int i=0; i<=9; i++) {
            memo[1][i] = 1;
        }
        for(int i=2; i<=64; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=0; k<=j; k++) {
                    memo[i][j] += memo[i-1][k];
                }
            }
        }

        for(int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            long result = 0;

            for(int i=0; i<=9; i++) {
                result+=memo[N][i];
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
