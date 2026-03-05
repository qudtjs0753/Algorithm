package Baekjoon;


import java.io.*;
import java.util.*;
public class Algo2812 {

    static int N,K, pollCount = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input = init();
        solve(input);
    }

    private static void solve(String input) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(input.charAt(0)-'0');

        for(int i=1; i<N; i++) {
            int num = input.charAt(i)-'0';
            if(dq.peekFirst()<num) {
                pollLessThan(dq, num);
            }
            dq.push(num);
        }

        if(pollCount<K) {
            while(pollCount<K) {
                pollCount++;
                dq.pollFirst();
            }
        }

        while(!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }

        System.out.println(sb);
    }

    private static String init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        return br.readLine();
    }

    private static void pollLessThan(Deque<Integer> dq, int num) {
        while(!dq.isEmpty() && dq.peekFirst()<num && pollCount<K) {
            dq.pop();
            pollCount++;
        }
    }
}
