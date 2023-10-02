package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo10859 {


    private static String N;
    private static long reversed = 0;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        if(!eratosthenes(Long.parseLong(N))) {
            System.out.println("no");
            return;
        }

        for (int i = N.length() - 1; i >= 0; i--) {
            long num = N.charAt(i) - '0';
            if (num == 3 || num == 4 || num == 7) {
                System.out.println("no");
                return;
            }

            reversed *= 10;

            if (num == 6) {
                reversed += 9;
                continue;
            }

            if (num == 9) {
                reversed += 6;
                continue;
            }

            reversed += num;
        }

        if(!eratosthenes(reversed)) {
            System.out.println("no");
            return;
        }
        System.out.println("yes");
    }

    private static boolean eratosthenes(long number) {
        if(number==1) return false;
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
    }
}
