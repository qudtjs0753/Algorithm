package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @Author: kbs
 */
public class Algo1260 {
    static int N,M,V;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        visited[V] = true;
        for (int i = 0; i < N+1; i++) arr[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int value1 = Integer.parseInt(st.nextToken());
            int value2 = Integer.parseInt(st.nextToken());
            arr[value1].add(value2);
            arr[value2].add(value1);
        }
        for (int i = 0; i < N+1; i++) Collections.sort(arr[i]);
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        visited[V] = true;
        bfs(V);
        System.out.println(sb);
    }
    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");
            for(int next : arr[num]){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;

                }
            }
        }
    }

    private static void dfs(int v) {
        sb.append(v).append(" ");

        for(int num : arr[v]){
            if(!visited[num]){
                visited[num] = true;
                dfs(num);
            }
        }
    }
}
