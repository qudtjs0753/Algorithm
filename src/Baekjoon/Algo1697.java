package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1697 {
    static int N, K;
    static int[] memo = new int[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(memo, 200000);
        memo[N] = 0;

        memoization();
        System.out.println(memo[K]);
    }

    private static void memoization() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        while (!q.isEmpty()) {
            int current = q.poll();
            if(current==K)return;
            if(current-1 >= 0 && memo[current-1]>memo[current]+1){
                memo[current-1] = memo[current] + 1;
                q.add(current-1);
            }
            if(current+1<=200000 && memo[current+1]>memo[current]+1){
                memo[current+1] = memo[current] + 1;
                q.add(current+1);
            }
            if(2*current<=200000 && memo[current*2]>memo[current]+1){
                memo[current*2] = memo[current] +1;
                q.add(2*current);
            }
        }
    }
}
