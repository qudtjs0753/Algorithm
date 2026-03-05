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
public class Algo2623 {
    static int N,M;
    static int[] inDegree;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N+1];
        map = new ArrayList[N+1];

        for(int i=0; i<=N; i++)map[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int root = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int child = Integer.parseInt(st.nextToken());
                map[root].add(child);
                inDegree[child]++;
                root = child;
            }
        }

        topologySort();
    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append("\n");
            for(int next : map[current]){
                inDegree[next]--;

                if(inDegree[next]==0)
                    q.add(next);
            }
        }

        boolean isSorted = true;
        for(int i=1; i<=N; i++){
            if(inDegree[i]!=0){
                isSorted = false;
                break;
            }
        }
        if(!isSorted)
            System.out.print(0);
        else
            System.out.print(sb);

    }
}
