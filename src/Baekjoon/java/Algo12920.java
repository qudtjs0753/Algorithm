package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo12920 {

    static int N, M;
    static int[] maxCount;
    static int[][] memo, thing;
    static int[][] countThingInsideBag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new int[N + 1][M + 1];
        thing = new int[N + 1][2];
        maxCount = new int[N + 1];
        countThingInsideBag = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            thing[i][0] = weight;
            thing[i][1] = value;
            maxCount[i] = count;
        }

        memoization();

        System.out.println(memo[N][M]);
    }

    /**
     * bitmasking
     * 각 물건의 개수별로 하나의 가방이라고 생각하게 만든다.
     * 이때 비트마스킹을 사용
     *
     */

    private static void memoization() {
    }
}
