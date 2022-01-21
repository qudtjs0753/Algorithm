package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11050 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int result = 1;
       for(int i=1; i<=N; i++){
           result *=i;
       }
       for(int i=1; i<=K; i++){
            result/=i;
       }
       for(int i=1; i<=N-K; i++){
           result/=i;
       }

        System.out.println(result);
    }
}
