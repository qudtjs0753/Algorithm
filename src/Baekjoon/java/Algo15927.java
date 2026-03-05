package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo15927 {

    static String input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        String reverse = sb.append(input).reverse().toString();

        if(!input.equals(reverse)) {
            System.out.println(input.length());
            return;
        }

        for(int i=0; i<input.length()/2; i++) {
            char ch = input.charAt(i);
            char compare = input.charAt(i+1);

            if(ch!=compare) {
                System.out.println(input.length()-1);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        input = br.readLine();
    }
}
