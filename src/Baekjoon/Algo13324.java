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
public class Algo13324 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());
            /**
             *     the first step is to get rid of the strictly increasing condition.
             *     apply a[i] -= i for all i and thus we just have to find the
             *     minimum number of moves to change it to a non-decreasing sequence.
             */
            num -= i;

            pq.add(num);
            if(pq.peek()>num){
                //기울기 조정.
                //r > ai 인 경우
                //기울기가 감소하는 부분과 증가하는 부분이 나뉘므로 이를 pq.poll(), pq.add()로 간단하게 해결.
                pq.poll();
                pq.add(num);
            }
            ans[i] = pq.peek();
        }

        for(int i=N-1; i>=1; i--)
            if(ans[i]>ans[i+1])ans[i] = ans[i+1];
        for(int i=1; i<=N; i++)
            sb.append(ans[i]+i).append("\n");
        System.out.print(sb);
    }
}
