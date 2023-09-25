package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2792 {

    static int N, M;

    static int[] arr;
    static int minimum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        System.out.println(binarySearch());

    }

    private static int binarySearch() {
        int left = 0, right = minimum;

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (!check(mid)) {
                left = mid;
            }else {
                right = mid;
            }
        }

        return right;
    }

    private static boolean check(int mid) {
        int remain = N - M;
        for (int i = 0; i < M; i++) {
            int dividend = arr[i]/mid;
            int remainder = arr[i]%mid;

            remain -= (dividend-1);
            if(remainder!=0) remain -=1;
        }

        if(remain>=0) return true;
        return false;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            minimum = Math.max(arr[i], minimum);
        }
    }
}
