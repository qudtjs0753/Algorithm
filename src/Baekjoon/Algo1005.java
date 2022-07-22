package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1005 {
    static int T, N, K, W;
    static int[] dist, inDegree;
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dist = new int[N+1];
            visit = new boolean[N+1];
            inDegree = new int[N+1];
            map = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) map[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                dist[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                map[v1].add(v2);
                inDegree[v2]++;
            }

            W = Integer.parseInt(br.readLine());

            sb.append(topologicalSort()).append("\n");
        }

        System.out.print(sb);
    }

    private static int topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];

        for(int i=1; i<=N; i++){
            result[i] = dist[i];

            if(inDegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int current = q.poll();

            for(Integer next : map[current]){
                result[next] = Math.max(result[next], result[current] + dist[next]);
                inDegree[next]--;

                if(inDegree[next]==0)q.add(next);
            }
        }

        return result[W];
    }
}
