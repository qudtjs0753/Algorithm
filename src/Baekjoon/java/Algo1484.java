package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1484 {

    private static int G;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();

        if(sb.length()==0) {
            sb.append(-1);
        }
        System.out.print(sb);
    }

    private static void solve() {
        long start = 1, end = 2;

        while(start<end) {
            if(end*end-start*start<G) {
                end++;
            }else if(end*end-start*start==G) {
                sb.append(end).append("\n");
                end++;
                start++;
            }else {
                start++;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
    }
}
