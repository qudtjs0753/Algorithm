package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Algo3964 {

    static int T;
    static ArrayList<Long> primes;
    static long[][] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < T; i++) {
            solve(input[i][0], input[i][1]);
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        input = new long[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Long.parseLong(st.nextToken());
            input[i][1] = Long.parseLong(st.nextToken());
        }
        primes = new ArrayList<>();
        createPrime();
    }

    private static void createPrime() {
        boolean[] isNotPrime = new boolean[(int) 1e6 + 1];
        for (long i = 2; i <= (long) 1e6; i++) {
            if (isNotPrime[(int) i]) continue;
            primes.add(i);
            for (long j = i * i; j <= (long) 1e6; j += i) {
                isNotPrime[(int) j] = true;
            }
        }
    }

    private static void solve(long n, long k) {
        Map<Long, Integer> countOfK = new TreeMap<>();
        //1. prime 얻기
        getCountOfK(countOfK, k);
        //2. n count ㄱㄱ
        getCountOfN(countOfK, n);
    }

    private static void getCountOfK(Map<Long, Integer> countOfNum, long k) {
        boolean isPrime = true;
        for (long prime : primes) {
            if (k == 1) return;
            if (k % prime != 0) continue;
            while (k % prime == 0) {
                isPrime = false;
                countOfNum.put(prime, countOfNum.getOrDefault(prime, 0) + 1);
                k /= prime;
            }
        }

        if (isPrime || k != 1) {
            countOfNum.put(k, 1);
        }
    }

    private static void getCountOfN(Map<Long, Integer> countOfK, long n) {
        long minCount = Long.MAX_VALUE;

        for (long key : countOfK.keySet()) {
            long cnt = 0;
            long num = n;

            while (num > 1) {
                num /= key;
                cnt += num;
            }

            minCount = Math.min(cnt / countOfK.get(key), minCount);
        }

        sb.append(minCount).append("\n");
    }
}
