package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo17412 {
    static int N, P;
    static int[][] capacity, flow;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        capacity = new int[N+1][N+1];
        flow = new int[N+1][N+1];


        for(int i=0; i<P; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            capacity[v1][v2] = 1;
        }

        System.out.println(networkFlow(1, 2));
    }

    private static int networkFlow(int source, int sink) {
        int totalFlow =0;


        while(true){
            int[] parent = new int[N+1];
            Queue<Integer> q = new ArrayDeque<>();

            Arrays.fill(parent, -1);
            parent[source] = source;
            q.add(source);

            while(!q.isEmpty() && parent[sink] == -1){
                int here = q.poll();

                for(int there = 1; there <= N; there++){
                    //현재 흐르는 유량이 capacity 이상인지 체크.
                    if(capacity[here][there] - flow[here][there] > 0 && parent[there] == -1){
                        q.add(there);
                        parent[there] = here;
                    }
                }
            }

            //만약 더이상 증가 경로가 없으면 종료
            if(parent[sink] == -1)break;

            int amount = Integer.MAX_VALUE;

            //지나는 간선의 최소 유량으로 더해줘야 하므로 Math.min을 사용함.
            for(int p = sink; p != source; p = parent[p]){
                amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);
            }
            System.out.println(amount);
            //최소 유량 더해줌.
            //반대방향은 -
            for(int p = sink; p != source; p = parent[p]) {
                flow[parent[p]][p] += amount;
                flow[p][parent[p]] -= amount;
            }
            totalFlow += amount;
        }
        return totalFlow;
    }
}
