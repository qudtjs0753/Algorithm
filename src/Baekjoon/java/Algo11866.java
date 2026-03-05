package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11866 {
    static int N,K,index=0;
    static Queue<Integer> queue = new LinkedList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    public static int josephus(){
        for(int i=0; i<K-1; i++){
            index=(index+1)%list.size();
        }

        return list.remove(index);
    }
    public static int findOrderByQueue(){
        for(int i=0; i<K-1; i++){
            int val = queue.poll();
            queue.offer(val);
        }
        return queue.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)queue.add(i+1);
        for(int i=0; i<N; i++) list.add(i+1);
        sb.append("<"+josephus());
        for(int i=0; i<N-1; i++){
            sb.append(", ");
            sb.append(josephus());
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}
