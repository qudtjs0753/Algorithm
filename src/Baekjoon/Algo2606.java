package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2606 {
    static ArrayList<Integer>[] arr;
    static int N,M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
        }

        System.out.println(bfs());


    }

    private static int bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : arr[current]){
                if(!visited[next]){
                    count++;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return count;
    }
}
