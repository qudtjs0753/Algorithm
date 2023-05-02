package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo3273 {

    static int N,X;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 200_000_000;
        Arrays.sort(arr,1,N+1);
        X = Integer.parseInt(br.readLine());

        int end = N;
        int sum =0, beforeSum = 0;
        for(int start=1; start<end; start++) {
            if(arr[start]==arr[start-1]) {
                sum += beforeSum;
                continue;
            }
            beforeSum = 0;

            while(arr[start]+arr[end]>=X && end>start) {
                if(arr[start]+arr[end]==X) {
                    beforeSum++;
                }
                end--;
            }
            sum += beforeSum;
        }

        System.out.println(sum);
    }
}
