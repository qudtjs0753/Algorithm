package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo6236 {

    static int N,M, max;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Integer.max(max, arr[i]);
        }

        System.out.print(binarySearch());
    }

    private static int binarySearch() {
        int lo = max-1, hi = 10_000*100_000;
        int count;

        while(lo+1<hi) {
            int mid = (lo+hi)/2;
            count = getCount(mid);
            if(count>M) { //너무 작은 숫자로 K를 잡은 경우엔
                lo = mid;
            }else {
                hi = mid;
            }
        }
        return hi;
    }

    private static int getCount(int k) {
        int remain = k;
        int count = 1;

        for(int i=0; i<N; i++) {
            remain -= arr[i];
            if (remain < 0) {
                ++count;
                remain = k - arr[i];
            }
        }
        return count;
    }
}
