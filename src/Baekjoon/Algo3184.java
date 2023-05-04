package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo3184 {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int liveSheep, liveWolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(liveSheep + " " + liveWolf);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        visit[y][x] = true;
        q.add(new int[]{y, x});
        int sheep = 0, wolf = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            if (map[current[0]][current[1]] == 'o') sheep++;
            else if (map[current[0]][current[1]] == 'v') wolf++;

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + current[0];
                int nx = dx[i] + current[1];

                if (isInvalid(ny, nx) || visit[ny][nx] || map[ny][nx] == '#') continue;

                visit[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }

        if (sheep > wolf) {
            liveSheep += sheep;
        } else {
            liveWolf += wolf;
        }
    }

    private static boolean isInvalid(int ny, int nx) {
        return (ny<0 || ny>=R || nx<0 || nx>=C);
    }
}
