package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1916 {
    static int N,M;
    static ArrayList<Integer>[] map;
    static int[] result;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N+1];
        result = new int[N+1];
        dist = new int[N+1][N+1];

        for(int i=0; i<N+1; i++){
            map[i] = new ArrayList<>();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            map[v1].add(v2);
            if(dist[v1][v2] > distance){
                dist[v1][v2] = distance;
            }

        }



        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dajikstra(start);

        System.out.println(result[end]);
    }

    private static void dajikstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();

            if(result[current[0]]<current[1])continue;

            for(int next : map[current[0]]){
                if(result[next] > result[current[0]] + dist[current[0]][next]){
                    result[next] = result[current[0]] + dist[current[0]][next];
                    pq.add(new int[] {next, result[next]});
                }
            }
        }
    }
}
