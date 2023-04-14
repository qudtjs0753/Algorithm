package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo25682 {


    static int N,M,K;
    static StringBuilder sb = new StringBuilder();

    static char[][] map;
    static int[][][] table;
    static int[][][] accSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        table = new int[2][N+1][M+1];
        accSum = new int[2][N+1][M+1];

        for(int i=1; i<=N; i++) {
            String input = br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = input.charAt(j-1);
            }
        }

        init();
        createAccSumTable();
        System.out.println(calculateMinimumAccSum());
    }

    private static void createAccSumTable() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                for(int firstColor=0; firstColor<2; firstColor++){
                    table[firstColor][i][j] = table[firstColor][i][j-1] + table[firstColor][i-1][j]
                            - table[firstColor][i-1][j-1] + table[firstColor][i][j];
                }
            }
        }
    }

    private static int calculateMinimumAccSum() {//누적합 계산
        int minimum = Integer.MAX_VALUE;
        for(int firstColor=0; firstColor<2; firstColor++) {
            for(int i=1; i<=N-K+1; i++) {
                for(int j=1; j<=M-K+1; j++) {
                    minimum = Math.min(minimum, table[firstColor][i+K-1][j+K-1] - table[firstColor][i+K-1][j-1]
                            - table[firstColor][i-1][j+K-1] + table[firstColor][i-1][j-1]);
                }
            }
        }
        return minimum;
    }

    /**
     *
     */
    private static void init() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
                    if(map[i][j]=='B') {
                        table[0][i][j] = 1;
                        table[1][i][j] = 0;
                    }else {
                        table[0][i][j] = 0;
                        table[1][i][j] = 1;
                    }
                }else {
                    if(map[i][j]=='B') {
                        table[0][i][j] = 0;
                        table[1][i][j] = 1;
                    }else {
                        table[0][i][j] = 1;
                        table[1][i][j] = 0;
                    }
                }
            }
        }
    }
}
