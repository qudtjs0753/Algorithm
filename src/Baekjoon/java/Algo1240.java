package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1240 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] arr;
    static int[][] dist;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        dist = new int[N+1][N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int distOf = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
            dist[v1][v2] = dist[v2][v1] = distOf;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            sb.append(findDist(v1,v2)).append("\n");
        }

        System.out.println(sb);
    }

    private static int findDist(int v1, int v2) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];
        visit[v1] = true;
        q.add(new int[]{v1, 0});

        while(!q.isEmpty()) {
            int[] current = q.poll();

            if(current[0]==v2) {
                return current[1];
            }
            for(int next : arr[current[0]]) {
                if(visit[next])continue;
                q.add(new int[]{next, current[1]+dist[current[0]][next]});
                visit[next] = true;
            }
        }
        return 0;
    }
}
