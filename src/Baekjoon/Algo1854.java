package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1854 {
    static int n, m, k;
    static ArrayList<Node>[] map;
    static PriorityQueue<Integer>[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];
        dist = new PriorityQueue[n+1];
        for(int i=0; i<=n; i++){
            map[i] = new ArrayList<>();
            //최대 힙.
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[start].add(new Node(end, weight));
        }
        djikstra();
        for(int i=1; i<=n; i++){
            if(dist[i].size()<k) sb.append(-1).append("\n");
            else{
                sb.append(dist[i].peek()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void djikstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        dist[1].add(0);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            //현재 거리가 저장되어있는 맨 아래 거리보다 길다면 out.
            if(current.distance > dist[current.end].peek()){
                continue;
            }
            for(Node next : map[current.end]){
                //시작점부터 다음 도착점까지의 거리 후보군이 k개 미만일때 그냥 일단 추가한다.
                if(dist[next.end].size()<k){
                    //현재 위치까지의 거리 + 현재 위치에서 다음 위치까지의 거리.
                    dist[next.end].add( current.distance + next.distance);

                    pq.add(new Node(next.end, current.distance + next.distance));
                    //K개 이상이 되면 현재 저장된 k번째 거리보다 거리가 작은 경우에 추가한다.
                }else if(dist[next.end].peek()>current.distance + next.distance){
                    dist[next.end].poll();
                    dist[next.end].add(current.distance + next.distance);
                    pq.add(new Node(next.end, current.distance + next.distance));
                }

            }
        }
    }

    static class Node implements Comparable<Node> {
        int end, distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o1){
            return this.distance - o1.distance;
        }
    }
}
