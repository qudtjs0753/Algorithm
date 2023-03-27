package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo2644 {

    static int N, M, personA, personB;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        personA = Integer.parseInt(st.nextToken());
        personB = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1].add(v2);
            map[v2].add(v1);
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        visit[personA] = true;
        q.add(personA);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int current = q.poll();

                for (int next : map[current]) {
                    if (visit[next]) continue;

                    if (next == personB) {
                        return depth;
                    }
                    q.add(next);
                    visit[next] = true;
                }
            }

            depth++;
        }


        return -1;
    }
}

