package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1051 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int length = Math.min(N, M);

        while (length > 1) {
            for (int i = 0; i <= N - length; i++) {
                for (int j = 0; j <= M - length; j++) {
                    if (map[i][j] == map[i][j + length - 1] &&  map[i][j] == map[i + length - 1][j]
                            && map[i][j]== map[i + length - 1][j + length - 1]) {
                        System.out.print(length * length);
                        return;
                    }
                }
            }
            length--;
        }

        System.out.print(length * length);

    }

}
