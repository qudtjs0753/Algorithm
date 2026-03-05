package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1407 {

    static Long A,B;

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(getSum(B)-getSum(A-1));
    }

    private static Long getSum(long number) {
        long addNumber = 1;
        long ret = 0;

        while(number>0) {
            final long countOfOne = number%2==0 ? number/2 : number/2 + 1;
            ret += countOfOne*addNumber;
            addNumber*=2;
            number /= 2;
        }
        return ret;
    }
}
