package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo20924 {

    static boolean findPillar = true;
    static int N, R;
    static ArrayList<int[]>[] map;
    static int pillarDist = 0, branchDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[v1].add(new int[]{v2,d});
            map[v2].add(new int[]{v1,d});
        }

        findDist();
        System.out.println(pillarDist + " " + (branchDist - pillarDist));
    }

    private static void findDist() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        q.add(new int[]{R,0});
        visit[R] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cnt = 0;
            for(int[] next : map[current[0]]) {
                if(visit[next[0]])continue;
                int nextDist = current[1] + next[1];
                branchDist = Math.max(branchDist,nextDist);
                q.add(new int[]{next[0], nextDist});
                visit[next[0]] = true;
                cnt++;
            }

            if(findPillar) {
                if(cnt>1) {
                    findPillar = false;
                }
                pillarDist = current[1];
            }
        }
    }

}
