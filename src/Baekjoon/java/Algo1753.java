package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1753 {
    static ArrayList<Node>[] tree;
    static int V, E, startNode;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        tree = new ArrayList[V+1];
        for(int i=0; i<V+1; i++)tree[i] = new ArrayList<>();

        dist = new int[V+1];
        for(int i=0; i<V+1; i++)dist[i] = Integer.MAX_VALUE;
        startNode = Integer.parseInt(br.readLine());


        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[start].add(new Node(end, weight));
        }
        dijkstra();
        for(int i=1; i<=V; i++){
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(){
        //priority queue에 담을 때는 시작점으로부터의 거리를 담는다. 즉 누적거리를 담아야 함.
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(startNode, 0));
        dist[startNode] = 0;

        while(!pq.isEmpty()){
            //가장 거리 짧은애 먼저 봄.
            Node current = pq.poll();

            if(dist[current.end]<current.weight)continue;

            for(int i=0; i<tree[current.end].size(); i++) {
                Node next = tree[current.end].get(i);
                int nextDistance = current.weight + tree[current.end].get(i).weight;
                if(nextDistance < dist[next.end]){
                    //distance 갱신
                    dist[next.end] = nextDistance;
                    //다음 목적지 추가. 이때 누적된 거리를 저장해야함.
                    pq.add(new Node(next.end, nextDistance));
                }
            }
        }

    }
    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
