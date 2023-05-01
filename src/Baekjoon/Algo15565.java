package Baekjoon;

import java.util.*;
import java.io.*;

public class Algo15565 {

    static int N, K;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int end = -1;
        int[] count = new int[3];

        for(int start=0; start<N; start++) {
            while(end<N-1 && count[1]<K) {
                end++;
                count[arr[end]]++;
            }
            if(count[1]==K) {
                min = Math.min(end-start+1, min);
            }

            count[arr[start]]--;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
