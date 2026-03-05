package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo2559 {
    static StringBuilder sb = new StringBuilder();
    static int N,K, max = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int sum = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++) {
            sum += arr[i];
        }
        max = sum;

        for(int i=K; i<N; i++) {
            sum-=arr[i-K];
            sum+=arr[i];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
