package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo2758 {
    static long[][] memo;
    static int T,N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            memo = new long[N+1][M+1];


            makeDPTable();
            sb.append(memo[N][M]).append("\n");
        }

        System.out.print(sb);
    }

    private static void makeDPTable() {
        for(int i=0; i<=M; i++){
            memo[0][i] = 1;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                //배낭문제로 생각하면 편하다.
                //i번째에 j를 골랐을 때는 i-1번째에 j/2를 골랐을 때와 경우의 수가 같으므로 그걸 더해주는 거고
                //j를 고르지 않은 나머지 케이스에 대해(1~ j-1) 누적해서 더해주는 것.
                memo[i][j] = memo[i-1][j/2] + memo[i][j-1];
            }
        }
    }
}
