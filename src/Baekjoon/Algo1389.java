package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1389 {
    static int N,M,min=Integer.MAX_VALUE, result;
    static ArrayList<Integer>[] relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relation = new ArrayList[N+1];
        for(int i=0; i<=N; i++)
            relation[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            relation[v1].add(v2);
            relation[v2].add(v1);
        }

        for(int i=1; i<=N; i++){
            bfs(i);
        }

        System.out.println(result);
    }

    private static void bfs(int person) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] order = new int[N+1];
        Arrays.fill(order, -1);
        order[person] = 0;
        q.add(person);
        int count = 0;
        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : relation[current]){
                if(order[next]==-1){
                    q.add(next);
                    order[next] = order[current]+1;
                    count += order[next];
                }
            }
        }

        if(count<min){
            min = count;
            result = person;
        }
    }
}
