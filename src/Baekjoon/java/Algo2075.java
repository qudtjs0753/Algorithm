package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo2075 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<N-1; i++)
            pq.poll();

        System.out.println(pq.poll());
    }


}
