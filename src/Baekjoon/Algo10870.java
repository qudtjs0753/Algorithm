package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo10870 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(fibo(0,1,0));
    }

    private static long fibo(int p, int pp, int n) {
        if(n<N)return fibo(pp, p+pp, n+1);
        return p;
    }
}
