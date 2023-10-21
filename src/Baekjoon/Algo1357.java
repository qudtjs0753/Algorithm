package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1357 {


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int v2 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

        int result = v1 + v2;

        System.out.println(Integer.parseInt(new StringBuilder(Integer.toString(result)).reverse().toString()));
    }
}
