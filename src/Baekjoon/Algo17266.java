package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo17266 {
    static int N, M;
    static int[] position;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        position = new int[M];
        st = new StringTokenizer(br.readLine());
        int minimum = 0;
        for (int i = 0; i < M; i++) {
            position[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(position);

        minimum = Math.max(minimum, position[0]);
        for (int i = 0; i < M - 1; i++) {
            minimum = Math.max(minimum, (position[i + 1] - position[i]) / 2
                    + (position[i + 1] - position[i]) % 2);
        }
        minimum = Math.max(minimum, N - position[M - 1]);

        System.out.print(minimum);
    }
}
