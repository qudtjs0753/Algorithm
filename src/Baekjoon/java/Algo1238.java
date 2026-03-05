package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1238 {
    static int N,M,X, max = 0;
    static final int MAX_VALUE = 100_000_000;

    static ArrayList<int[]>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            map[i] = new ArrayList<>();
        }
        int start,end,dist;
        int[] goHome = new int[N+1], goX;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());
            map[start].add(new int[]{end, dist});
        }
        dajikstra(X, goHome);

        for(int i=1; i<=N; i++){
            goX = new int[N+1];
            dajikstra(i, goX);
            max = Math.max(max,goHome[i] + goX[X]);
        }

        System.out.println(max);
    }

    private static void dajikstra(int start,int[] dist){
        //[0] : endpoint, [1] : cumulatedDist
        PriorityQueue<int[]> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        nodes.add(new int[] {start, 0});
        Arrays.fill(dist, MAX_VALUE);
        dist[start] = 0;

        while(!nodes.isEmpty()){
            int[] current = nodes.poll();

            if(current[1] > dist[current[0]])continue;

            for(int[] next : map[current[0]]){
                int nextDist = dist[current[0]] + next[1];
                if(dist[next[0]] > nextDist){
                    dist[next[0]] = nextDist;
                    nodes.add(next);
                }
            }
        }
    }
}
