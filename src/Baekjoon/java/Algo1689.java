package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1689 {

    static int N;
    static ArrayList<Node> arr = new ArrayList<>(2*N);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int result = 0;
        for(int i=0; i<arr.size(); i++) {
            Node current = arr.get(i);
            if(!current.isStart) {
                q.add(current.x);
                continue;
            }
            while(!q.isEmpty()) {
                q.poll();
                cnt--;
            }
            cnt++;
            result = Math.max(cnt, result);
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr.add(new Node(true, start));
            arr.add(new Node(false,end));
        }

        Collections.sort(arr, (o1, o2) -> {
            if (o1.x == o2.x) {
                if (!o1.isStart) {
                    return -1;
                }
                return 1;
            }

            return o1.x - o2.x;
        });
    }

    private static class Node {
        int x;
        boolean isStart;

        public Node(boolean isStart, int x) {
            this.x = x;
            this.isStart = isStart;
        }
    }
}
