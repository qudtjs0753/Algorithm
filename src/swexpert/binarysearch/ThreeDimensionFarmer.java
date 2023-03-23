package swexpert.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeDimensionFarmer {

    static int N, M, x1, x2;
    static int[] cow, horse;
    static int minimum = Integer.MAX_VALUE;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            minimum = Integer.MAX_VALUE;
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cow = new int[N];
            horse = new int[M];


            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cow[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                horse[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(cow);
            Arrays.sort(horse);

            for (int i = 0; i < N; i++) {
                parametricSearch(cow[i]);
            }

            sb.append("#").append(testCase).append(" ")
                    .append(Math.abs(x1 - x2) + minimum).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static void parametricSearch(int key) {
        int lo = -1, hi = M; //

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            //horse의 mid가 key보다 크면 hi를 줄인다.
            if (!(horse[mid] < key)) {
                hi = mid;
            } else {
                lo = mid; //작거나 같은 경우.
            }
        }
        check(key, lo);
        check(key, hi);

    }

    private static void check(int key, int index) {
        if (index == -1) {
            return;
        }

        if (index == M) {
            return;
        }

        int min = Math.abs(key - horse[index]);

        if (min < minimum) {
            minimum = min;
            count = 1;
            return;
        }
        if (min == minimum) {
            count++;
        }
    }
}
