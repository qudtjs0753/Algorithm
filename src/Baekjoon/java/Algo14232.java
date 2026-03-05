package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Algo14232 {

    private static long k;
    private static int numberOfStolen = 0;
    private static List<Long> divisors = new ArrayList<>((int)1e6);


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        findDivisors();
        divide();
        System.out.println(numberOfStolen);
        System.out.println(sb);
    }

    private static void findDivisors() {
        for(long i=2; i*i<=k; i++) {
            if(k%i==0) {
                divisors.add(i);
            }
        }

        int size = divisors.size();

        for(int i=0; i<size; i++) {
            divisors.add(k/divisors.get(i));
        }
        divisors.add(k);
    }


    private static void divide() {
        int idx = 0;
        long divisor;
        while(k>1) {
            divisor = divisors.get(idx);
            while(k%divisors.get(idx)==0) {
                sb.append(divisor).append(" ");
                numberOfStolen++;
                k/=divisor;
            }
            idx++;
        }
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());

    }
}
