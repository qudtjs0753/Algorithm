package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo14267 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] point;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        point = new int[N+1];
        for(int i=0; i<=N; i++) graph[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for(int i=2; i<=N; i++) {
            int v = Integer.parseInt(st.nextToken());
            graph[v].add(i);
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            point[v] += p;
        }
        
        bfs();

        for(int i=1; i<=N; i++) {
            sb.append(point[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int next : graph[current]) {
                point[next] += point[current];
                q.add(next);
            }
        }
    }
}
