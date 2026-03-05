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
public class Algo12851 {
    static int N, K, min_count = 1;
    static int[] time = new int[150001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(time, 150000);
        bfs();

        System.out.println(time[K]);
        System.out.println(min_count);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        time[N] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            if(2*current <= 150000 && time[2*current]>=time[current]+1){
                q.add(2*current);
                checkTime(current, 2*current);
            }

            if(current-1>=0 && time[current-1]>= time[current]+1){
                q.add(current-1);
                checkTime(current, current-1);
            }


            if(current+1<=150000 && time[current+1]>= time[current]+1){
                q.add(current+1);
                checkTime(current, current+1);
            }
        }
    }

    private static void checkTime(int current, int newIdx){
        if(time[newIdx]>time[current]+1){
            time[newIdx] = time[current]+1;
            if(newIdx==K)
                min_count=1;
        }else if(time[current]+1== time[newIdx] && newIdx==K){
            min_count++;
        }
    }
}
