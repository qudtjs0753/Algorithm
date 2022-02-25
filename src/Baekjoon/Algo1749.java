package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1749 {
    static int N,M;
    static int[][] matrix;
    static long[][]  memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N+1][M+1];
        memo = new long[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createMemoTable();

        System.out.println(findMaxMatrix());
    }

    private static long findMaxMatrix() {
        long maxValue = Long.MIN_VALUE;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                for(int k=i; k<=N; k++){
                    for(int l=j; l<=M; l++){
                        maxValue = Math.max(calculateMaxSum(i,j,k,l), maxValue);
                    }
                }
            }
        }

        return maxValue;
    }

    private static long calculateMaxSum(int y1, int x1, int y2, int x2) {
        return memo[y2][x2] - memo[y1-1][x2] - memo[y2][x1-1] + memo[y1-1][x1-1];
    }

    private static void createMemoTable() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                memo[i][j] = memo[i-1][j] + memo[i][j-1] + matrix[i][j] - memo[i-1][j-1];
            }
        }
    }
}
