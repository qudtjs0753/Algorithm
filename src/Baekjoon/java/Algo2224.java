package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2224 {

    private static final int MAX = 20000;
    private static final int START = 65;
    private static final int END = 122;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[200][200];
        visit = new boolean[200][200];

        for (int i = 0; i <= 199; i++) {
            Arrays.fill(map[i], MAX);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " => ");
            int v1 = st.nextToken().charAt(0);
            int v2 = st.nextToken().charAt(0);
            if (v1 == v2) map[v1][v2] = 0;
            else map[v1][v2] = 1;
        }


        floyd(map);


        //create answer
        int count = 0;
        for (int i = START; i <= END; i++) {
            for (int j = START; j <= END; j++) {
                if (i != j && map[i][j] > 0 && map[i][j] < MAX) {
                    count++;
                    sb.append((char) i).append(" => ").append((char) j).append("\n");
                }
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }

    private static void floyd(int[][] map) {
        for (int k = START; k <= END; k++) {
            for (int i = START; i <= END; i++) {
                if (i == k) continue;
                for (int j = START; j <= END; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}
