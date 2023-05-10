package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo15900 {

    static int N, result;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
        }

        //시작점 1.
        bfs();
        if(result%2==1) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];
        visit[1] = true;
        q.add(new int[]{1,0});

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int count = 0;
            for(int next : arr[current[0]]) {
                if(visit[next])continue;
                count++;

                q.add(new int[]{next, current[1]+1});
                visit[current[0]] = true;
            }

            if(count==0) {
                result+=current[1];
            }
        }
    }
}
