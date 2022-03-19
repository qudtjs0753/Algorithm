package Baekjoon;

import java.beans.Visibility;
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11725 {
    static int N;
    static ArrayList<Integer>[] arr;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++)arr[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
        }

        bfs();

        for(int i=2; i<=N; i++)sb.append(parent[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        parent[1] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for(int next : arr[current]){
                if(parent[next]==0){
                    parent[next] = current;
                    q.add(next);
                }
            }
        }
    }
}
