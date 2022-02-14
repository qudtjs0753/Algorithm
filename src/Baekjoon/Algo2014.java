package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2014 {
    static int K, N;
    static ArrayList<Long> primes = new ArrayList<>();
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            long input = Integer.parseInt(st.nextToken());
            primes.add(input);
            pq.add(input);
        }

        Collections.sort(primes);

        System.out.println(findNthNumber());
    }

    private static long findNthNumber(){
        long ret = 0;
        while(N-->0){
            ret = pq.poll();

            for(long next: primes){

                if(ret * next >= ((long)2<<30))break;

                pq.add(next*ret);

                if(ret % next == 0)break;
            }
        }
        return ret;
    }
}
