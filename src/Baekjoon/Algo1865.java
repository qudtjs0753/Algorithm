package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1865 {
    private static class Node {
        int vertex,weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    static final int MAX_DIST = 500_000_000;
    static int T, N, M, W;
    static int[] dist;
    static ArrayList<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new ArrayList[N+1];
            dist = new int[N+1];
            Arrays.fill(dist, MAX_DIST);
//            for(int i=0; i<=N; i++)map[i] = new ArrayList<>();

            Arrays.fill(map, new ArrayList<Node>());
            dist[1] = 0;

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                map[s].add(new Node(e, t));
                map[e].add(new Node(s, t));
            }
            for(int i=0; i<W; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                map[s].add(new Node(e, -t));
            }

            if(bellmanFord()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean bellmanFord() {
        boolean isUpdated=false;

        for(int iter = 1; iter<=N; iter++){
            isUpdated=false;
            //최소거리 찾는 과정
            for(int here=1; here<=N; here++){
                for(Node next : map[here]){
                    if(dist[next.vertex] > dist[here] + next.weight){
                        dist[next.vertex] = dist[here] + next.weight;
                        if(iter==N) isUpdated=true;
                    }
                }
            }
        }


        return isUpdated;
    }
}
