package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo1277 {
    static int N, W;
    static Double minimum = Double.MAX_VALUE;
    static double[] dist;
    static boolean[][] connected;
    static double M;
    static long[][] map;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println((long)(minimum*1000));
    }

    private static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.dist));
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if(current.end==N) {
                minimum = current.dist;
                return;
            }

            for (int i = 2; i <= N; i++) {
                double newDist = getDistance(current, i);
                if (newDist + current.dist < dist[i] && newDist<M) {
                    pq.add(new Node(i, newDist+current.dist));
                    dist[i] = newDist + current.dist;
                }
            }
        }
    }

    private static double getDistance(Node current, int i) {
        if(connected[current.end][i]) return 0;
        long yMult = (map[current.end][0] - map[i][0]) * (map[current.end][0] - map[i][0]);
        long xMult = (map[current.end][1] - map[i][1]) * (map[current.end][1] - map[i][1]);
        return Math.sqrt(yMult + xMult);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new long[N + 1][2];
        M = Double.parseDouble(br.readLine());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        dist = new double[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        connected = new boolean[N+1][N+1];
        for(int i = 1; i<=W; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            connected[v1][v2] = true;
            connected[v2][v1] = true;
        }
    }

    static class Node {
        int end;
        double dist;

        public Node(int end, double dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}
