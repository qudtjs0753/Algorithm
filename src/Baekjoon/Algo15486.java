package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo15486 {
    static int[][] consult;
    static int[] memo;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        memo = new int[N+2];
        consult = new int[N+4][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            consult[i][0] = Integer.parseInt(st.nextToken());
            consult[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(memo,-1);
        goOut(1);
        System.out.println(memo[1]);
    }

    private static int goOut(int date) {
        if(date>N+1) {
            return -20_000_000; //날짜가 넘어간 경우를 단순하게 처리해주는 로직
        }

        if(date==N+1) {
            return 0;
        }

        if(memo[date]!=-1) {
            return memo[date];
        }

        return memo[date] = Math.max(
                goOut(date+consult[date][0]) + consult[date][1], //더하는 경우
                goOut(date+1)
        );
    }

}
