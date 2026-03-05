package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11660 {
    static int N, M;
    static int[][] sum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                sum[i][j] = sum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            findSum(y1,x1,y2,x2);
        }
        System.out.println(sb);
    }

    private static void findSum(int y1, int x1, int y2, int x2) {
        int ret = 0;
        for(int i=y1; i<=y2; i++){
            ret += sum[i][x2] - sum[i][x1-1];
        }
        sb.append(ret).append("\n");
    }
}
