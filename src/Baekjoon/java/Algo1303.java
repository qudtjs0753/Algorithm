package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1303 {

    static int N,M;
    static boolean[][] visit;
    static char[][] map;
    static int[] score = new int[2];
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visit[i][j]) bfs(i,j);
            }
        }

        System.out.print(score[0] + " " + score[1]);
    }

    private static void bfs(int startY, int startX) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startY,startX});
        char toMatch = map[startY][startX];
        visit[startY][startX] = true;
        int scoreIdx=0;

        if(toMatch=='B') {
            scoreIdx = 1;
        }
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i=0; i<4; i++) {
                int ny = dy[i] + current[0];
                int nx = dx[i] + current[1];

                if(isInvalid(ny,nx) || visit[ny][nx] || map[ny][nx]!=toMatch) continue;
                q.add(new int[]{ny,nx});
                visit[ny][nx]=true;
                cnt++;
            }
        }
        score[scoreIdx] += cnt*cnt;
    }

    private static boolean isInvalid(int ny, int nx) {
        return ny>=N || ny<0 || nx>=M || nx<0;
    }
}
