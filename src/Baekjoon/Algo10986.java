package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo10986 {

    static int N,M;
    static int[] remainder;
    static long[] accSum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        accSum = new long[N+1];
        remainder = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            accSum[i] = accSum[i-1] + Integer.parseInt(st.nextToken());
            remainder[(int)(accSum[i] % M)]++;
        }
        long result = (long)remainder[0]*(remainder[0]-1)/2 + remainder[0];

        for(int diff=1; diff<M; diff++) {
            result += (long) remainder[diff] *(remainder[diff]-1)/2;
        }

        System.out.println(result);
    }
}
