package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo16919 {

    static int R,C,N;
    static int[] dy = {0,-1,0,1,0};
    static int[] dx = {0,0,1,0, -1};
    static int[][][] map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[6][R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if(input.charAt(j)=='O') {
                    map[0][i][j] = 1;
                }
            }
        }

        init();

        if(N!=1) {
            N = (N-2)%4 + 2;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[N][i][j]>0) {
                    sb.append('O');
                }else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void init() {
        for(int i=1; i<=5; i++) {
            createMap(i);
        }
    }

    private static void createMap(int time) {
        if(time%2==0) {
            addBomb(time);
        }else {
            popBomb(time);
        }
    }
    private static void addBomb(int time) {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) { //그냥 모든 곳에 폭탄 넣을것이니 카운트 더해준다.
               map[time][i][j]=map[time-1][i][j] + 1;
            }
        }
    }
    private static void popBomb(int time) {
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[time-1][i][j]!=0) {//폭탄이 설치되었다면 카운트 더해준다.
                    map[time][i][j] = map[time-1][i][j] + 1;
                }
            }
        }

        //q에 추가
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[time][i][j]==4) {
                    q.add(new int[]{i,j});
                }
            }
        }

        //pop
        while(!q.isEmpty()) {
            int[] current = q.poll();
            popBomb(current[0], current[1], time);
        }
    }

    private static void popBomb(int y, int x, int time) {
        for(int i=0; i<5; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if(isInvalid(ny,nx)) {
                continue;
            }
            map[time][ny][nx] = 0;
        }
    }

    private static boolean isInvalid(int ny, int nx) {
        return (ny<0 || ny>=R || nx<0 || nx>=C);
    }
}
