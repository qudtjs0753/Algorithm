package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo4803 {

    static int N, M, result;
    static boolean[] visit;
    static boolean[][] route;
    static ArrayList<Integer>[] map;
    static StringBuilder sb = new StringBuilder();

    /**
     * 그래프
     * 하나 이상의 연결 요소로 이루어져 있음.
     * 사이클이 없음.
     * 정점 n개 , 간선 n-1개
     * 경로의 유일성
     * 풀이전략. 간선 수와 정점수를 세서 n개, n-1개가 나와야 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testCase = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;
            if(N==0 && M==0) break;

            map = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                map[i] = new ArrayList<>();
            }
            visit = new boolean[N + 1];
            route = new boolean[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                map[v1].add(v2);
                map[v2].add(v1);
            }

            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    bfs(i);
                }
            }

            if (result == 0) {
                sb.append("Case ").append(testCase).append(": No trees.\n");
            } else if (result == 1) {
                sb.append("Case ").append(testCase).append(": There is one tree.\n");
            } else {
                sb.append("Case ").append(testCase).append(": A forest of ").append(result).append(" trees.\n");
            }
            testCase++;
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int startIdx) {
        Queue<Integer> q = new ArrayDeque<>();
        int countForPoint = 1, countForRoute = 0;
        visit[startIdx] = true;
        q.add(startIdx);

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : map[current]) {
                if (!visit[next]) {
                    q.add(next);
                    visit[next] = true;
                    countForPoint++;
                }

                if (!route[current][next] && !route[next][current]) {
                    countForRoute++;
                    route[current][next] = true;
                    route[next][current] = true;
                }
            }
        }
        if (countForPoint == countForRoute + 1) {
            result++;
        }
    }
}
