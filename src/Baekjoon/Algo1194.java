package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Algo1194 {

    static int N, M, result = -1, startY, startX;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[1 << 6][N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == '0') {
                    startY = i;
                    startX = j;
                    map[i][j] = '.';
                }
            }
        }

        find();
        System.out.println(result);
    }

    private static void find() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
        pq.add(new int[]{startY, startX, 0, 0}); //y,x,key,
        visit[0][startY][startX] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + current[0];
                int nx = dx[i] + current[1];

                if (isInvalid(ny, nx) || visit[current[2]][ny][nx] || map[ny][nx] == '#') continue;

                if (map[ny][nx] == '1') {
                    result = current[3] + 1;
                    return;
                }

                if (map[ny][nx] == '.') {
                    visit[current[2]][ny][nx] = true;
                    pq.add(new int[]{ny, nx, current[2], current[3] + 1});
                    continue;
                }

                int key;
                if (Character.isUpperCase(map[ny][nx])) {
                    key = 1 << (map[ny][nx] - 'A');
                    if ((key & current[2]) != 0) {
                        visit[current[2]][ny][nx] = true;
                        pq.add(new int[]{ny, nx, current[2], current[3] + 1});
                    }
                } else {
                    key = 1 << (map[ny][nx] - 'a');
                    visit[current[2]][ny][nx] = true;
                    pq.add(new int[]{ny, nx, current[2] | key, current[3] + 1});
                }
            }
        }
    }

    private static boolean isInvalid(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= M;
    }
}
