package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2252 {
    static int N, M;
    static int[] inDegree;
    static ArrayList<Integer>[] root;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> dfsResult = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        root = new ArrayList[N+1];
        for(int i=0; i<=N; i++)root[i] = new ArrayList<>();
        inDegree = new int[N+1];
        visited = new boolean[N+1];


        int x, y;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x=  Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            //큰 녀석의 아래에 작은 녀석을 추가.
            root[x].add(y);
        }
        for(int i=1; i<=N; i++){
            if(!visited[i])
            topologySortByDFS(i);
        }

       while(!dfsResult.isEmpty())
            sb.append(dfsResult.pop()).append(" ");
        System.out.println(sb);
    }


    static void topologySortByDFS(int node){
        visited[node] = true;
        for(int i=0; i<root[node].size(); i++){
            int next = root[node].get(i);
            if(!visited[next])
                topologySortByDFS(next);
        }
        dfsResult.push(node);
    }


}
