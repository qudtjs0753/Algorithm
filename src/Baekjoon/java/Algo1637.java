package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo1637 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //A
            arr[i][2] = Integer.parseInt(st.nextToken()); //C
            arr[i][1] = Integer.parseInt(st.nextToken()); //B
            //a,b,c 순으로 저장
        }
        binarySearch();
    }

    private static void binarySearch() {
        long lo = 0, hi = Integer.MAX_VALUE+1L;

        while (lo+1 < hi) {
            long mid = (lo + hi) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                sum += getCount(arr[i][0], arr[i][1], arr[i][2], (int) mid);
            }

            if (sum % 2 == 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        int count;
        if (hi==Integer.MAX_VALUE+1L) {
            System.out.println("NOTHING");
            return;
        } else {
            count = getCountFor(hi);
        }

        System.out.println(hi + " " + count);
    }

    private static int getCountFor(long ans) {
        int result = 0;

        for (int i = 0; i < N; i++) {
            //1. C보다 작거나 같아야 함
            if (arr[i][2] < ans) continue;

            //2. A보다 크거나 같아야 함.
            if (arr[i][0] > ans) continue;

            //3. 동일해야 함
            if ((ans - arr[i][0]) % arr[i][1] == 0) {
                result += 1;
            }
        }

        return result;
    }

    private static int getCount(int A, int B, int C, int mid) {
        if (A > mid) return 0;
        if (C < mid) return (C - A) / B + 1;
        return (mid - A) / B + 1;
    }
}
