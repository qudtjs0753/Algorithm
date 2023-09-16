package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo2467 {

    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<N-1; i++) {
            int key = -arr[i];
            int result = binarySearch(i+1, key);
            int diff = Math.abs(result + arr[i]);
            if(diff<minDiff) {
                sb = new StringBuilder();
                sb.append(arr[i]).append(" ").append(result);
                minDiff = diff;
            }
        }

        System.out.println(sb);
    }

    private static int binarySearch(int start, int key) {
        int end = N;
        int diff = Integer.MAX_VALUE;

        while(start+1<end) {
            int mid = (start+end)/2;
            if(arr[mid]<=key) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if(start==N-1) return arr[start];

        if(Math.abs(key-arr[start])<Math.abs(key-arr[end])) {
            return arr[start];
        }
        return arr[end];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
