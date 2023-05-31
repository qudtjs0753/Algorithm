package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1949 {

    static int N;
    static int[] population;
    static ArrayList<Integer>[] map;
    static int[][] memo;
    static int result = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        population = new int[N+1];
        map = new ArrayList[N+1];
        memo = new int[2][N+1];
        for(int i=0; i<=N; i++) map[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++) {
            memo[1][i] = population[i];
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1].add(v2);
            map[v2].add(v1);
        }

        //0, 1을 써서 사용한 경우와 안한 경우를 나눈다
        //만약 이전에 1, 즉 우수마을로 지정이 되었으면 0으로 무조건 가야함
        //하지만 0이었으면, 0 1 둘다 됨
        dfs(1, 0);
        System.out.println(Math.max(memo[0][1], memo[1][1]));
    }

    private static void dfs(int current, int parent) {
        for(int next : map[current]) {
            if(next==parent) continue;
            dfs(next, current);
            memo[1][current] += memo[0][next];
            memo[0][current] += Math.max(memo[0][next], memo[1][next]);
        }
    }
}
