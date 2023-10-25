package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo16934 {


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
        int num = Integer.parseInt(br.readLine());

        System.out.println(num - 1946);
    }
}
