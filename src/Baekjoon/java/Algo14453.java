package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo14453 {

    private static int[][] acc;
    private static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int result = 0;
        for (int i = 0; i <= N; i++) {
            //3P2 -> 6가지
            //'P' -> 'H'
            result = Math.max(result, acc['P'-'A'][i] + (acc['H'-'A'][N] - acc['H'-'A'][i]));
            result = Math.max(result, acc['H'-'A'][i] + (acc['P'-'A'][N] - acc['P'-'A'][i]));
            result = Math.max(result, acc['S'-'A'][i] + (acc['H'-'A'][N] - acc['H'-'A'][i]));
            result = Math.max(result, acc['H'-'A'][i] + (acc['S'-'A'][N] - acc['S'-'A'][i]));
            result = Math.max(result, acc['P'-'A'][i] + (acc['S'-'A'][N] - acc['S'-'A'][i]));
            result = Math.max(result, acc['S'-'A'][i] + (acc['P'-'A'][N] - acc['P'-'A'][i]));
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        acc = new int[26][N + 1];

        for (int i = 1; i <= N; i++) {
            char input = br.readLine().charAt(0);
            acc['P' - 'A'][i] = acc['P' - 'A'][i - 1];
            acc['S' - 'A'][i] = acc['S' - 'A'][i - 1];
            acc['H' - 'A'][i] = acc['H' - 'A'][i - 1];
            if (input == 'H') {
                acc['P' - 'A'][i] += 1;
                continue;
            }
            if (input == 'P') {
                acc['S' - 'A'][i] += 1;
                continue;
            }
            acc['H' - 'A'][i] += 1;
        }

    }
}
