package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2696 {
    static int T,M;
    static PriorityQueue<Integer> increasingOrder;
    static PriorityQueue<Integer> decreasingOrder;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            M = Integer.parseInt(br.readLine());
            increasingOrder = new PriorityQueue<>();
            decreasingOrder = new PriorityQueue<>(Collections.reverseOrder());
            findMedian();
        }
        System.out.println(sb);

    }

    private static void findMedian() throws IOException {
        int count=0;
        sb.append(M/2 + M%2).append("\n");

        while(count<M/2 + M%2){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(increasingOrder.size()==decreasingOrder.size()){
                    if(!increasingOrder.isEmpty() && increasingOrder.peek()<num){
                        decreasingOrder.add(increasingOrder.poll());
                        increasingOrder.add(num);
                        sb.append(decreasingOrder.peek()).append(" ");
                    }else{
                        decreasingOrder.add(num);
                        sb.append(decreasingOrder.peek()).append(" ");
                    }
                    count++;
                    if(count!=0 && count%10==0)sb.append("\n");
                }else{
                    if(decreasingOrder.peek()>num){
                        increasingOrder.add(decreasingOrder.poll());
                        decreasingOrder.add(num);
                    }else{
                        increasingOrder.add(num);
                    }
                }
            }
        }

        sb.append("\n");
    }
}
