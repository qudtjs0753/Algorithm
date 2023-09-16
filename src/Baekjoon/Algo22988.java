package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo22988 {

    static int N;
    static long X;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int end = arr.length - 1;

        int result = 0;
        int noCount = 0;

        while (end >= 0 && arr[end] == X) {
            result++;
            end--;
        }

        int start = 0;

        for (; start < end; start++) {
            if ((arr[start] + arr[end])*2 >= X) { // X -> long ->
                result++;
                end--;
                continue;
            }
            noCount++;
        }

        //1. start = end -2 , -> start==end , start=end-1 -> start=end or start>end
        if (start == end) {
            noCount++;
        }

        System.out.println(result + (noCount / 3));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
    }
}
