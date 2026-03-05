package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo9465 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, memo;
    static int T, N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        int max = 0;
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            map = new int[2][100000];
            memo = new int[2][100000];
            max = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N;i++){
                map[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N;i++){
                map[1][i] = Integer.parseInt(st.nextToken());
            }

            memo[0][0] = map[0][0];
            memo[0][1] = map[0][1] + map[1][0];
            memo[1][0] = map[1][0];
            memo[1][1] = map[1][1] + map[0][0];

            for(int i=2; i<N; i++){
                memo[0][i] = Math.max(memo[1][i-2],
                        memo[1][i-1]) + map[0][i];
                max = Math.max(memo[0][i], max);
                memo[1][i] = Math.max(memo[0][i-2],
                        memo[0][i-1]) + map[1][i];
                max = Math.max(memo[1][i], max);

            }

            sb.append(Math.max(memo[1][N-1],memo[0][N-1])).append("\n");
        }
        System.out.println(sb);
    }
}
