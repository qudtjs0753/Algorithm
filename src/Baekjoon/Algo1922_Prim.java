package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1922_Prim {
    static int N, M, minWeight = 0;

    static ArrayList<Node>[] network;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        network = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < N + 1; i++) network[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            network[vertex1].add(new Node(vertex2, weight));
            network[vertex2].add(new Node(vertex1, weight));
        }
        prim();
        System.out.println(minWeight);
    }

    public static void prim(){
        int count = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        pq.addAll(network[1]);

        visited[1] = true;

        while(!pq.isEmpty()){
            if(count==N-1)return;
            Node node = pq.poll();
            if(!visited[node.vertex]){
                count++;
                visited[node.vertex] = true;
                minWeight += node.weight;
                pq.addAll(network[node.vertex]);
            }
        }
    }


    private static class Node {
        int vertex, weight;

        public Node(int end, int weight) {
            this.vertex = end;
            this.weight = weight;
        }
    }
}
