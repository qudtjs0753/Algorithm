package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo4948 {

    static int[] primeCount;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int input = Integer.parseInt(br.readLine());
            if(input==0) break;
            sb.append(primeCount[2*input]-primeCount[input]).append("\n");
        }

        System.out.println(sb);
    }

    private static void init() {
        primeCount = new int[123456*2 + 1];

        for(int i=2; i<=123456*2; i++) {
            boolean isPrime = true;
            for(int j=2; j*j<=i; j++) {
                if(i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            primeCount[i]=primeCount[i-1];
            if(isPrime) {
                primeCount[i]++;
            }
        }
    }
}
