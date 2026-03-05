package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo2056 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] time,sum;
    static int[] inbound;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        inbound = new int[N + 1];
        map = new ArrayList[N + 1];
        sum = new int[N + 1];
        for(int i=0; i<N+1; i++) map[i] = new ArrayList<>();

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            if(cnt==0) {
                q.add(i);
                sum[i] = time[i];
            }
            for (int j = 0; j < cnt; j++) {
                int v1 = Integer.parseInt(st.nextToken());
                map[v1].add(i);
                inbound[i]++;
            }
        }

        bfs(q);
    }

    private static void bfs(Queue<Integer> q) {
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int current = q.poll();
                for(int next : map[current]) {
                    sum[next] = Math.max(sum[current], sum[next]);
                    inbound[next]--;
                    if(inbound[next]==0) {
                        q.add(next);
                        sum[next] += time[next];
                    }
                }
            }
        }
        int result = 0;
        for(int i=0; i<=N; i++) {
            result = Math.max(sum[i],result);
        }
        System.out.println(result);
    }
}
