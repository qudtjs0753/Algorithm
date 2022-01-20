package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1735 {
    static int divisor1, divisor2, dividend1, dividend2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dividend1 = Integer.parseInt(st.nextToken());
        divisor1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        dividend2 = Integer.parseInt(st.nextToken());
        divisor2 = Integer.parseInt(st.nextToken());

        dividend1 = divisor2 * dividend1;
        dividend2 = divisor1 * dividend2;

        int gcd = gcd(dividend1 + dividend2, divisor1 * divisor2);
        System.out.println((dividend1 + dividend2)/gcd + " " + divisor1*divisor2/gcd );
    }

    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
