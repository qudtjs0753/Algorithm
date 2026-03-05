package Baekjoon;
import java.io.*;
import java.util.*;
public class Algo15988 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            long[] memo = new long[N+1];
            memo[1] = 1;
            if(N>=2) memo[2] = 2;
            if(N>=3) memo[3] = 4;

            for(int i=4; i<=N; i++) {
                memo[i] = (memo[i-1]+ memo[i-2]+ memo[i-3])%1_000_000_009;
            }
            sb.append(memo[N]).append("\n");
        }
        System.out.println(sb);
    }
}
