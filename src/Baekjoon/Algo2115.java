package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo2115 {

    static int N,M, result = 0;
    static boolean[][] map;
    static int[][] wallsY,wallsX;


    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for(int i=1; i<N; i++) {
            for(int j=1; j<M; j++) {
                if(map[i-1][j]!=map[i][j]) {
                    if(map[i][j]==map[i][j-1] && map[i-1][j]==map[i-1][j-1]) {
                        wallsX[i][j] = wallsX[i][j-1]+1;
                    }else {
                        wallsX[i][j] = 1;
                        result+=wallsX[i][j-1]/2;
                    }
                }else {
                    result += wallsX[i][j-1]/2;
                }
            }
        }


        for(int j=1; j<M; j++) {
            for(int i=1; i<N; i++) {
                if(map[i][j-1]!=map[i][j]) {
                    if(map[i-1][j-1]==map[i][j-1] && map[i-1][j]==map[i][j]) {
                        wallsY[i][j] = wallsY[i-1][j]+1;
                    }else {
                        wallsY[i][j] = 1;
                        result+=wallsY[i-1][j]/2;
                    }
                }else {
                    result += wallsY[i-1][j]/2;
                }
            }
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        wallsY = new int[N][M];
        wallsX = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                if(input.charAt(j)=='.') {
                    map[i][j] = true;
                }
            }
        }
    }
}
