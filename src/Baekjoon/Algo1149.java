package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo1149 {
    static int N;
    static int[][] houses;
    static int[][] memo;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houses = new int[N][3];
        memo = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(memo[i], 1_500_000);
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = Math.min(
                Math.min(
                        paint(0, 0),
                        paint(0, 1)),
                paint(0, 2));

        System.out.println(result);
    }

    private static int paint(int currentHouse, int paintColor) {
        if (currentHouse == N) {
            return 0;
        }

        if (memo[currentHouse][paintColor] != 1_500_000) return memo[currentHouse][paintColor];

        for (int i = 0; i <= 2; i++) {
            if (paintColor == i) continue;
            memo[currentHouse][paintColor] =
                    Math.min(memo[currentHouse][paintColor],
                            paint(currentHouse + 1, i));
        }
        memo[currentHouse][paintColor] += houses[currentHouse][paintColor];

        return memo[currentHouse][paintColor];
    }
}
