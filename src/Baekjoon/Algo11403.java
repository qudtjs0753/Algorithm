package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11403 {
    static int N;
    static int[][] map;
    static int[][] ans;
    static boolean[] visited, isExist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        ans = new int[N][N];
        isExist = new boolean[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                    isExist[i] = true;
            }
        }

        for(int i=0; i<N; i++){
                visited = new boolean[N];
                bfs(i);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int idx) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);

        while (!q.isEmpty()) {
            int current = q.poll();

            for(int i=0; i<N; i++){
                if(map[current][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    ans[idx][i] = 1;
                }
            }
        }
    }
}
