package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo14928 {

    private static final int DIVISOR = 20000303;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int remainder = 0;
        for (int i = 0; i < num.length(); i++) {
            remainder = (10 * remainder + num.charAt(i) - '0') % DIVISOR;
        }
        System.out.println(remainder);
    }
}
