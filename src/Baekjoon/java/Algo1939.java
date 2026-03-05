package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algo1939 {

    static int N, M,start,end, left, right;
    static ArrayList<Node>[] map;
    static int[] maxWeight;
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        right+=1;
        int mid;

        while(left+1<right) {
            mid = (left+right)/2;

            if(find(mid)) {
                left = mid;
            }else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    private static boolean find(int mid) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];
        q.add(start);
        visit[start] = true;
        while(!q.isEmpty()) {
            int current = q.poll();
            if(current == end)  return true;
            for(Node next : map[current]) {
                if(next.weight>=mid && !visit[next.end]) {
                    q.add(next.end);
                    visit[next.end]=true;
                }
            }
        }
        return false;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxWeight = new int[N+1];
        Arrays.fill(maxWeight, -1);
        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[v1].add(new Node(v2, weight));
            map[v2].add(new Node(v1, weight));

            left = Math.min(weight,left);
            right = Math.max(weight, right);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
    private static class Node {
        int weight, end;

        public Node(int end, int weight) {
            this.weight = weight;
            this.end = end;
        }
    }
}
