package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @Author: kbs
 */
public class Algo11286 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
        if(Math.abs(o1)==Math.abs(o2)){
            return o1-o2;
        }else{
            return Math.abs(o1)-Math.abs(o2);
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input;
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            input = Integer.parseInt(br.readLine());

            if(input==0){
                if(pq.isEmpty())sb.append(0).append("\n");
                else{
                    int output =pq.poll();
                    sb.append(output).append("\n");
                }
            }else{
                pq.add(input);
            }
        }
        System.out.println(sb);
    }
}
