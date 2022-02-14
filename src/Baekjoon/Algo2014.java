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
    static ArrayList<Integer> primes = new ArrayList<>();
    static PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(st.nextToken());
            primes.add(input);
            result.add(input);
            pq.add(input);
        }

        Collections.sort(primes);

        findNthNumber();

        System.out.println(result.poll());
    }

    private static void findNthNumber(){
        while(!pq.isEmpty()){
            int current = pq.poll();
            int idx = 0;
            for(int i = K-1;i>=0; i--){
                if(current % primes.get(i) ==0){
                    idx = i;
                    break;
                }
            }
            for(int i = idx; i<K; i++){
                long candidate = (long)current*primes.get(i);

                //Integer 범위를 벗어나는경우 그냥 out.
                if(candidate >= Integer.MAX_VALUE);
                else if(result.size()<N){
                    pq.add((int)candidate);
                    result.add((int)candidate);
                }else{
                    //저장된 result가 N개를 넘으면 일단 버린다.
                    if(candidate < result.peek()){
                        //N개있는데 제일 큰값보다 작은게 들어오면 넣는다.
                        pq.add((int)candidate);
                        result.poll();
                        result.add((int)candidate);
                    }
                    if(result.size()>N)result.poll();
                }
            }
        }
    }
}
