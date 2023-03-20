package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algo16932 {
    static int N, M, result = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] sum;
    static int[][] map;
    static int[][] number;
    static boolean[][] visitForCreate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        number = new int[N][M];
        visitForCreate = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        sum = new int[N * M + 1];

        //각 모양 번호로 체크.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visitForCreate[i][j]) {
                    sum[count] = bfs(i, j, count);
                    count++;
                }
            }
        }


        //최대치 찾는 곳.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    findMaximumShape(i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(int y, int x, int count) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        int ret = 1;
        visitForCreate[y][x] = true;
        number[y][x] = count;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < dy.length; i++) {
                int ny = dy[i] + current[0];
                int nx = dx[i] + current[1];

                if (isInvalid(ny, nx) || visitForCreate[ny][nx] || map[ny][nx] == 0) continue;

                q.add(new int[]{ny, nx});
                visitForCreate[ny][nx] = true;
                number[ny][nx] = count;
                ret++;
            }
        }

        return ret;
    }

    private static boolean isInvalid(int y, int x) {
        return (y < 0 || y >= N || x < 0 || x >= M);
    }

    private static void findMaximumShape(int y, int x) {
        HashSet<Integer> visit = new HashSet<>();
        int ret = 0;
        for (int i = 0; i < dy.length; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (isInvalid(ny, nx) || visit.contains(number[ny][nx]) || map[ny][nx] == 0) continue;

            visit.add(number[ny][nx]);
            ret += sum[number[ny][nx]];
        }

        result = Math.max(result, ret + 1);
    }
}
