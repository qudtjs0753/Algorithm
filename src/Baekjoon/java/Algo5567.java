package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo5567 {

    static int N, M, ans;
    static ArrayList<Integer>[] friends;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        friends = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            friends[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            friends[v1].add(v2);
            friends[v2].add(v1);
        }

        bfs();

        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];
        q.add(1);
        visit[1] = true;
        int depth = 1;
        while(!q.isEmpty() && depth<=2) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int current = q.poll();
                for(int next : friends[current]) {
                    if(visit[next]) continue;
                    q.add(next);
                    visit[next] = true;
                    ans++;
                }
            }
            depth++;
        }
    }
}
