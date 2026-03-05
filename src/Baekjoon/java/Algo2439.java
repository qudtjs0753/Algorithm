package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo2439 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N-i; j++){
                sb.append(" ");
            }
            for(int j=1; j<=i; j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
