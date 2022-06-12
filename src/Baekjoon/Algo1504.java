package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1504 {
    static int V, E;
    static ArrayList<Node>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new ArrayList[V+1];
        for (int i = 0; i < V + 1; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[v1].add(new Node(v2, dist));
            map[v2].add(new Node(v1, dist));
        }

        //루트 탐색
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long minAtoB = dijkstra(a,b);
        long dist1 = dijkstra(1, a) + minAtoB + dijkstra(b, V);
        long dist2 = dijkstra(1, b) + minAtoB + dijkstra(a, V);

        long result = Math.min(dist1, dist2);

        if(result>=Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    private static long dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(dist[current.end] < current.dist)continue;

            for(Node next : map[current.end]){
                int nextDist = current.dist + next.dist;

                if(dist[next.end] > nextDist){
                    dist[next.end] = nextDist;
                    pq.add(new Node(next.end, nextDist));
                }
            }
        }

        return dist[end];
    }
    static class Node {
        int end, dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
