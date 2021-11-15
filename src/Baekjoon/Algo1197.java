package Baekjoon;


import java.io.*;
import java.util.*;

public class Algo1197 {
    static int V, E;
    static final int MAX_V = 100;
    static final int INF = Integer.MAX_VALUE;


    public static class Node implements Comparable<Node> {
        int vertexTo, weight;

        public Node(int vertexTo, int weight){
            super();
            this.vertexTo = vertexTo;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.weight, o.weight);
        }
    }

    static List<Node>[] adj;

    public static long prim(){
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        long ret = 0;
        int count = 0;

        while(!pq.isEmpty()){
            //priority queue의 첫번째 값 반환 + queue에서 제거
            //priority queue의 첫번째 값이 가장 weight가 적은 값이므로.
            //compareTo에 정의됨.
            Node edge = pq.poll();
            if(visited[edge.vertexTo])continue;

            ret += edge.weight;
            visited[edge.vertexTo] = true;

            if(++count == V) return ret;
            //1번 vertex와 이어진 점들과의 가중치 탐색.
            for(int i=0; i< adj[edge.vertexTo].size(); i++){
                Node next = adj[edge.vertexTo].get(i);
                //만약 이미 트리내부에 있는 점이면 추가하지 않고 넘어간다.
                if(visited[next.vertexTo]) continue;
                pq.add(next);
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V + 1];
        for (int i=1; i<=V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());
            int c = Integer.parseInt(input.nextToken());
            //인접리스트
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        System.out.println(prim());
    }
}
