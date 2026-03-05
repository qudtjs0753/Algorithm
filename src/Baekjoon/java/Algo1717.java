package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1717 {
    static int N,M;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0; i<N+1; i++)parent[i] = i;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            if(operation==0){
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            else{
                printResult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA>parentB)parent[parentA] = parentB;
        else parent[parentB] = parentA;
    }

    static int find(int a){
        if(parent[a]==a)return a;
        else return parent[a] = find(parent[a]);
    }

    static void printResult(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA==parentB) sb.append("YES\n");
        else sb.append("NO\n");
    }
}
