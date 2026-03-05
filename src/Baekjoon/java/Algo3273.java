package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo3273 {

    static int N, X;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int end = N - 1;

        long result = 0;
        int beforeCount = 0;

        for (int start = 0; start < N - 1; start++) {
            int currentCount = 0;

            while (start < end && arr[start] + arr[end] >= X) {
                if (arr[start] + arr[end] == X) {
                    currentCount++;
                }
                end--;
            }

            if (start != 0 && arr[start] == arr[start - 1]) {
                result += beforeCount;
                continue;
            }
            result += currentCount;
            beforeCount = currentCount;
        }

        System.out.println(result);
    }
}
