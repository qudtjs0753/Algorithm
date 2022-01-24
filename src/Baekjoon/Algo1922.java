package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1922 {
    static int N, M;
    static int[] parent;
    static ArrayList<Node> network = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        int minWeight = 0;
        int count =0;
        for(int i=0; i<N+1; i++) parent[i] = i;
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            network.add(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        Collections.sort(network, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        for(int i=0; i<M; i++){
            Node node = network.get(i);
            if(count==N-1)break;
            if(!(find(node.end)==find(node.start))){
                minWeight += node.weight;
                union(node.start, node.end);
                count ++;
            }
        }
        System.out.println(minWeight);
    }
    private static void union(int vertex1, int vertex2){
        int parent1 = find(vertex1);
        int parent2 = find(vertex2);
        if(parent1>parent2)parent[parent1] = parent2;
        else parent[parent2] = parent1;
    }
    private static int find(int start) {
        if(start==parent[start])return start;
        else return parent[start] = find(parent[start]);
    }


    private static class Node {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
