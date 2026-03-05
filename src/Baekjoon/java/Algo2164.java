package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: kbs
 */
public class Algo2164 {
    static int N;
    static Deque<Integer> dq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=N; i>=1; i--) dq.push(i);

        while(dq.size()!=1){
            dq.removeFirst();
            int temp = dq.pollFirst();
            dq.addLast(temp);
        }
        System.out.println(dq.pop());
    }
}
