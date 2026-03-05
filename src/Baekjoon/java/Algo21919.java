package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo21919 {
    static int N;
    static Set<Long> primes = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            checkPrime(input);
        }
        if(primes.size()==0) System.out.println(-1);
        else System.out.println(makeLCM());

    }

    private static long makeLCM() {
        long lcm=1;
        for(long prime : primes){
            lcm*=prime;
        }
        return lcm;
    }

    private static void checkPrime(long input) {
        boolean isPrime = true;
        for(int i=2; i*i<=input; i++){
            if(input % i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime)
            primes.add(input);
    }
}
