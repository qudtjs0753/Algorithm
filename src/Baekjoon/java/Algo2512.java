package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo2512 {

    static int N;
    static long allSum;
    static long[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        allSum = Long.parseLong(br.readLine());
        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long lo = 1, hi = arr[N-1]+1;
        long mid;
        while (lo + 1 < hi) {
            mid = (lo + hi) / 2;
            long sum = getSum(mid);
            if (!(sum <= allSum)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return lo;
    }

    private static long getSum(long limit) {
        long ret = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i]<limit) {
                ret += arr[i];
            }else {
                ret += limit;
            }
        }

        return ret;
    }
}
