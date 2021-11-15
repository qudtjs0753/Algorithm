package Baekjoon;


import java.io.*;
import java.util.*;

public class Algo1197 {
    static int V, E;
    static final int MAX_V = 100;
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] adj;

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


    public static long prim(List<Node> selected){
        boolean[] visited = new boolean[V+1];
        int[] minWeight = new int[V+1];
        for(int i=1; i<V+1; i++){
            minWeight[i] = Integer.MAX_VALUE;
        }
        int[] parent = new int[V+1];
        //1번부터 시작
        minWeight[1] = parent[1] = 0;


        long ret = 0;
        int count = 0;

        for(int iter=0; iter<V; iter++){
            //모든 점 다 체크
            //edge 다 돌면서 최소인거 씀.
            int u = -1;
            for(int v = 1; v< V+1; v++)
                if(!visited[v] && (u == -1 || (minWeight[u] > minWeight[v]))) u = v;
            if(parent[u] != u) selected.add(new Node(parent[u], u));
            ret += minWeight[u];
            visited[u] = true;
            //u에 인접한 간선 (u,v)들을 검사한다.
            for(int i=0; i< adj[u].size(); i++){
                int v = adj[u].get(i).vertexTo;
                int weight = adj[u].get(i).weight;
                if(!visited[v] && minWeight[v] > weight){
                    parent[v] = u;
                    minWeight[v] = weight;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        List<Node> selected = new ArrayList<>();
        adj = new ArrayList[V + 1];

        for (int i=0; i<=V; i++){
            adj[i] = new ArrayList<Node>();
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
        int a = 0;

        System.out.println(prim(selected));
    }
}
