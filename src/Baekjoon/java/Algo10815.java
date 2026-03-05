package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo10815 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(isIn(Integer.parseInt(st.nextToken()))).append(" ");
        }

        System.out.println(sb);
    }

    private static int isIn(int key) {
        int start = 0, end = N;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (arr[mid] <= key) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr[start] == key) return 1;
        return 0;
    }
}
