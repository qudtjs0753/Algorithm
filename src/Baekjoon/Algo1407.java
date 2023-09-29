package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1407 {

    static Long A,B;

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
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(getSum(B)-getSum(A-1));
    }

    private static Long getSum(long number) {
        long countOfSum = 0;
        long addNumber = 1;
        long ret = 0;
        while(number>0) {
            if(number%2==0) {
                countOfSum=number/2;
            }else {
                countOfSum = number/2 + 1;
            }
            ret += countOfSum*addNumber;
            addNumber*=2;
            number -= countOfSum;
        }

        return ret;
    }
}
