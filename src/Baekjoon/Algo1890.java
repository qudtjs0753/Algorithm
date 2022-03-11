package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1890 {
    static int N;
    static int[][] map;
    static long[][] memo;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        memo = new long[N][N];
        memo[0][0] = 1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (x == N - 1 && y == N - 1) break;

                if (memo[y][x] == 0) continue;

                for (int i = 0; i< 2; i++) {
                    int ny = y + dy[i] * map[y][x];
                    int nx = x + dx[i] * map[y][x];

                    if (ny>N-1 || nx>N-1) continue;
                    memo[ny][nx] += memo[y][x];
                }
            }
        }

        System.out.println(memo[N-1][N-1]);
    }


}
