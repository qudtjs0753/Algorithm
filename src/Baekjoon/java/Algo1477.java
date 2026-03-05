package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo1477 {

    static int N, M, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    /**
     * binarysearch
     * 문제뒤집기
     * 어떻게 해야 최대 거리를 최소로 만들 수 있을까
     */
    private static void solve() {
        int minimumLength = 0, maximumLength = L - 1;

        while (minimumLength + 1 < maximumLength) {
            int mid = (minimumLength + maximumLength) / 2;

            if (canCreateLengthOf(mid)) {
                maximumLength = mid;
            } else {
                minimumLength = mid;
            }
        }
        System.out.println(maximumLength);
    }

    private static boolean canCreateLengthOf(int length) {
        int cnt = 0;

        for (int i = 0; i <= N; i++) {
            int distance = arr[i + 1] - arr[i];
            cnt += distance / length -1;
            if(distance%length!=0) cnt++;
        }

        if (cnt > M) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + 2];
        arr[0] = 0;
        arr[N + 1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
