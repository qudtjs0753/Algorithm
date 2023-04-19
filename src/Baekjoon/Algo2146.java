package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo2146 {

    static int N;
    static Queue<int[]> edges = new ArrayDeque<>(10000);
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideNation();


        while(!edges.isEmpty()) {
            int[] current = edges.poll();
            checkMinimumDist(current[0], current[1]);
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (map[i][j] != 0) {
//                    checkMinimumDist(i, j);
//                }
//            }
//        }
        System.out.println(ans);
    }

    private static void checkMinimumDist(int startY, int startX) {
        int nation = map[startY][startX];
        int depth = 1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        visit[startY][startX] = true;
        q.add(new int[]{startY, startX});


        while (!q.isEmpty()) {
            int size = q.size();

            for (int count = 0; count < size; count++) {
                int[] current = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + current[0];
                    int nx = dx[i] + current[1];

                    if (isInvalid(ny, nx) || map[ny][nx] == nation || visit[ny][nx]) {
                        continue;
                    }

                    if(map[ny][nx]!=0 && map[ny][nx]!=nation) {
                        ans = Math.min(depth-1, ans);
                    }

                    visit[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                }
            }
            depth++;
        }
    }


    private static void divideNation() {
        int cnt = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    check(cnt, i, j);
                    cnt++;
                }
            }
        }
    }

    private static void check(int cnt, int startY, int startX) {
        Queue<int[]> q = new ArrayDeque<>();
        map[startY][startX] = cnt;
        q.add(new int[]{startY, startX});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            boolean isEdge = false;
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + current[0];
                int nx = dx[i] + current[1];

                if (isInvalid(ny, nx) || map[ny][nx] != 1) {
                    if(!isEdge) {
                        edges.add(new int[]{current[0],current[1]});
                        isEdge = true;
                    }
                    continue;
                }

                q.add(new int[]{ny, nx});
                map[ny][nx] = cnt;
            }
        }
    }

    private static boolean isInvalid(int y, int x) {
        return (y >= N || y < 0 || x >= N || x < 0);
    }
}
