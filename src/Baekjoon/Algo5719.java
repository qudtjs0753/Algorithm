package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo5719 {

    //1. 다익스트라로 최단경로 찾기
    //2. 이때 각각의 경로에 대해 size 두개짜리 우선순위 queue 만들어 놓기
    //3. 다 돌고나서 최단경로의 합에서 각각의 경로를 뺐다 더하면서 새로운 경로사이즈 저장.
    static ArrayList<Node>[] map;
    static ArrayList<Integer>[] trace;
    static boolean [][] isShortest; //a에서 b로 가는 간선이 최단거리인가?
    static int[] dist;
    static boolean[] minVertex;

    static int N,M,S,D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int start, end, weight;
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0)break;
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            dist = new int[N];
            map = new ArrayList[N];
            trace = new ArrayList[N];
            minVertex = new boolean[N];
            isShortest = new boolean[N][N];

            for(int i=0; i<N; i++){
                map[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE;
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                map[start].add(new Node(end, weight));
            }

            djikstra(S);

            if(dist[D]==Integer.MAX_VALUE){
                sb.append(-1).append("\n");
                continue;
            }

            findShortestEdge(D,S);
            djikstra(S);

            if(dist[D]!=Integer.MAX_VALUE){
                sb.append(dist[D]).append("\n");
            }else{
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }


    //목적지부터 출발지까지 역으로 찾아가면서 가장 짧은 경로들을 check해서 이후 다익스트라를 실행할 때 그 경로를
    //체크하지 못하도록 한다.
    private static void findShortestEdge(int current, int end) {
        if (current == end) {
            return;
        }
        for (int next : trace[current]) {
            if (!isShortest[next][current]) {
                isShortest[next][current] = true;
                findShortestEdge(next, end);
            }
        }
    }



    private static void djikstra(int start) {
        for(int i=0; i<N; i++){
            trace[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if(current.distance>dist[current.vertex]){
                continue;
            }

            for(Node next : map[current.vertex]){
                if(isShortest[current.vertex][next.vertex]) continue;
                int nextDistance = current.distance + next.distance;
                if(nextDistance < dist[next.vertex]){
                    //clear를 하는 이유. trace 배열에 더 짧은 길이가 발견되면 그 길이를 기준으로 루트의 정보를 담아야함.
                    trace[next.vertex].clear();
                    trace[next.vertex].add(current.vertex);
                    dist[next.vertex] = nextDistance;
                    pq.add(new Node(next.vertex, nextDistance));
                }
                if(dist[next.vertex] == nextDistance) trace[next.vertex].add(current.vertex);
            }
        }
    }
    static class Node implements Comparable<Node> {
        int vertex, distance;
        public Node(int end, int distance) {
            this.vertex = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o1){
            return this.distance - o1.distance;
        }
    }
}
