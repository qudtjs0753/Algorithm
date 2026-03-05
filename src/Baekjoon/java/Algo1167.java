package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1167 {
    static class Node {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static ArrayList<Node>[] tree;
    static int V;
    static boolean[] visited;
    static PriorityQueue<Long> allDist = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];
        visited = new boolean[V+1];
        for (int i = 0; i <= V; i++) tree[i] = new ArrayList<>();

        StringTokenizer st;

        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            while(true){
                int v2 = Integer.parseInt(st.nextToken());
                if(v2==-1)break;
                int w = Integer.parseInt(st.nextToken());
                tree[v1].add(new Node(v2, w));
            }
        }


        System.out.println(dfsAll(1));
    }

    private static long dfsAll(int vertex){
        PriorityQueue<Long> dist = new PriorityQueue<>(Collections.reverseOrder());
        visited[vertex] = true;

        for(Node next : tree[vertex]){
            if(!visited[next.end]){
                visited[next.end] = true;
                dist.add(dfs(next.end, next.weight));
            }
        }

        if(dist.size()>=2){
            long max = dist.poll();
            allDist.add(max+dist.poll());
        }
        else if(dist.size()==1) {
            long max = dist.poll();
            allDist.add(max);
        }

        return allDist.poll();
    }


    //들어갈때마다 더하면서 그 정점에서 dfs를 호출하면서 비교한다.
    //
    private static long dfs(int vertex, int weight) {
        PriorityQueue<Long> dist = new PriorityQueue<>(Collections.reverseOrder());

        for(Node next: tree[vertex]){
            if(!visited[next.end]){
                visited[next.end]= true;
                dist.add(dfs(next.end, next.weight));
            }
        }

        if(dist.size()>=2){
            long max = dist.poll();
            allDist.add(max+dist.poll());
            return max + weight;
        }
        else if(dist.size()==1){
            long max = dist.poll();
            allDist.add(max);
            return max + weight;
        }

        return weight;
    }
}
