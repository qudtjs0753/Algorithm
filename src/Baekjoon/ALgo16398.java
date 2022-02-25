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
public class ALgo16398 {
    static class Node {
        int start,end,weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int N;
    static int[] parent;
    static ArrayList<Node> network = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[N+1];
        for(int i=0; i<N+1; i++) parent[i] = i;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<i; j++){
                network.add(new Node(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        System.out.println(kruskal());
    }

    private static long kruskal() {
        Collections.sort(network, Comparator.comparingInt(o -> o.weight));

        int count = 0;
        long ret = 0;
        for(Node next : network){
            if(count==N-1)break;
            if(union(next.start, next.end)){
                count++;
                ret+=next.weight;
            }
        }

        return ret;
    }

    private static boolean union(int a, int b) {
        int vertexA = find(a);
        int vertexB = find(b);
        if(vertexA==vertexB)return false;
        else{
            if(vertexA>vertexB){
                parent[vertexA] = vertexB;
            }else{
                parent[vertexB] = vertexA;
            }
        }
        return true;
    }


    private static int find(int i) {
        if(parent[i] == i) return i;
        else return parent[i] = find(parent[i]);
    }

}
