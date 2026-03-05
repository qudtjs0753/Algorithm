package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo7795 {
    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int result = 0;
            for (int i = 0; i < N; i++) {
                result += binarySearch(A[i]);
            }

            sb.append(result).append("\n");
        }


        System.out.println(sb.toString());
    }

    private static int binarySearch(int key) {
        int left = -1, right = M;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (!(B[mid] >= key)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
