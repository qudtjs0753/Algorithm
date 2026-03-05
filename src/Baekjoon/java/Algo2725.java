package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2725 {

    private static int C, N;
    private static int[] count = new int[1001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        count[0] = 0;
        count[1] = 3;

        //1. 100만개 하나하나 뒤진다
        for (int num = 2; num <= 1000; num++) {
            int cnt = 0;
            for (int divisor = 1; divisor < num; divisor++) {
                if (gcd(num, divisor) == 1) cnt++;
            }
            count[num] = count[num - 1] + 2 * cnt;
        }

        //2. 저장한것 토대로 값들을 찾는다.
        for (int i = 0; i < C; i++) {
            sb.append(count[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int num, int divisor) {
        if (divisor == 0) return num;
        return gcd(divisor, num % divisor);
    }
}
