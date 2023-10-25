package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2600 {

    static int[] b;
    static int[][] memo;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }

    private static void solve(int k1, int k2) {
        int winner = findWinner(k1, k2);

        if (winner == 0) sb.append("A").append("\n");
        else sb.append("B").append("\n");
    }

    private static int findWinner(int k1, int k2) {
        if(k1 < 0 || k2 < 0) return 0;

        if (memo[k1][k2] != -1) return (memo[k1][k2]+1)%2;

        //모든 경우의 수를 고려하여 다 지면 winner는 다른사람.
        //즉, 현재 경우에서 모두 지는지만 확인하면 된다.
        //하나라도 이기면 이긴거다
        //반환할때는 자신은 이겼으니 이전 사람에게는 0을 반환하여 졌다고 표기
        for (int i = 0; i < 3; i++) {
            if (findWinner(k1 - b[i], k2) == 1 || findWinner(k1, k2 - b[i]) == 1) {
                memo[k1][k2]=1;
                return 0;
            }
        }

        memo[k1][k2]=0;
        return (memo[k1][k2] + 1) % 2;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        b = new int[3];
        b[0] = Integer.parseInt(st.nextToken());
        b[1] = Integer.parseInt(st.nextToken());
        b[2] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());
            memo = new int[k1 + 1][k2 + 1];
            for (int a = 0; a <= k1; a++) {
                Arrays.fill(memo[a], -1);
            }
            solve(k1, k2);
        }
    }
}
