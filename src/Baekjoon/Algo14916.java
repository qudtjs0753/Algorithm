package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo14916 {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        int result = Integer.MAX_VALUE;
        for(int five=0 ; five<=N/5; five++) {
            int remain = N - 5*five;
            if(remain%2!=0) {
                continue;
            }

            result = Math.min(result, five + remain/2);
        }

        if(result==Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }
}
