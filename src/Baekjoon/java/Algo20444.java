package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo20444 {

    static long N,M;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
       long left = 1, right = N/2+2;

       while(left+1<right) {
           long mid = (left+right)/2;
           long mult = mid*(N+2-mid);

           if(mult<=M) {
              left = mid;
           }else {
               right = mid;
           }
       }
        if(left*(N+2-left)==M) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
    }
}
