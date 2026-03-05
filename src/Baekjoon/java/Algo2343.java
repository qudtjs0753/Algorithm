package Baekjoon;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;
public class Algo2343 {

    static int N,M, min;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.max(arr[i], min);
        }

        System.out.print(binarySearch());
    }

    private static int binarySearch() {
        int lo = min -1, hi = (int)1e9;

        while(lo+1 < hi) {
            int mid = (lo+hi)/2;
            int size = getSizeOf(mid);

            if(!(size>M)) {
                hi = mid;
            }else {
                lo = mid;
            }
        }
        return hi;
    }

    private static int getSizeOf(int mid) {
        int sum = 0;
        int count = 1;

        for(int i=0; i<N; i++) {
            if(sum+arr[i] > mid) {
                sum = 0;
                count++;
            }
            sum += arr[i];
        }
        if(sum > mid) count++;
        return count;
    }
}
