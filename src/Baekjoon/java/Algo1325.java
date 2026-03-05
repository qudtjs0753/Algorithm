package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1325 {
    static int N,M;
    static ArrayList<Integer>[] arr;
    static int[] hack;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new ArrayList[N+1];
        hack = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
        }

        dfsAll();

        findMax();
        System.out.println(sb);
    }

    private static void dfsAll(){
        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            dfs(i);
        }
    }
    private static void dfs(int start) {
        visited[start] = true;

        for(int next : arr[start]){
            if(!visited[next]){
                hack[next]++;
                dfs(next);
            }
        }
    }

    private static void findMax() {
        int max = 0;

        for(int i=1; i<=N; i++){
            if(hack[i] > max){
                sb = new StringBuilder();
                max = hack[i];
                sb.append(i).append(" ");
            }else if(hack[i] == max){
                sb.append(i).append(" ");
            }
        }
    }
}
