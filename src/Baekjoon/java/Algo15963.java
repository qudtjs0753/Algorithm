package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo15963 {


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        if(N==M) System.out.println(1);
        else System.out.println(0);
    }
}
