package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo3176 {
    static int N, K, levelN=0;
    static int minValue, maxValue;
    static int[][] parent, minLength, maxLength;
    static int[] depth;
    static ArrayList<Node>[] network;
    static final int INF = 1000001;
    static class Node{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        exp();
        parent = new int[levelN+1][N+1];
        minLength = new int[levelN+1][N+1];
        maxLength = new int[levelN+1][N+1];
        network = new ArrayList[N+1];
        depth = new int[N+1];
        for (int i = 0; i < N+1; i++) network[i] = new ArrayList<>();



        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            network[v1].add(new Node(v2, weight));
            network[v2].add(new Node(v1, weight));
        }

        completeSparse();

        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            getLCA(v1,v2);
            sb.append(minValue).append(" ").append(maxValue).append("\n");
        }
        System.out.println(sb);
    }
    //우선 N을 2^k로 나타냄.
    public static void exp(){
        for(int k=1; k<N; k*=2){
            levelN++;
        }
    }
    public static void getLCA(int a, int b){
        minValue = INF;
        maxValue = 0;

        if(depth[b]>depth[a]){
            getLCA(b,a);
            return;
        }

        for(int i=0; i<=levelN; i++){
            if(((depth[a]-depth[b]) & (1<<i)) >=1){
                minValue = Math.min(minValue, minLength[i][a]);
                maxValue = Math.max(maxValue, maxLength[i][a]);
                a = parent[i][a];
            }
        }

        if(a==b){
            return;
        }

        for(int i=levelN; i>=0; i--){
            if(parent[i][a]!=parent[i][b]){
                minValue = Math.min(minValue, Math.min(minLength[i][a],minLength[i][b]));
                maxValue = Math.max(maxValue, Math.max(maxLength[i][a],maxLength[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        //마지막 부모에 도달하는 거리
        minValue = Math.min(minValue, Math.min(minLength[0][a],minLength[0][b]));
        maxValue = Math.max(maxValue, Math.max(maxLength[0][a],maxLength[0][b]));
    }

    public static void completeSparse(){
        initializeSparse();

        //2^0부터 하나씩올린다?
        for(int k=1;k<=levelN;k++){
            for(int i=1; i<=N; i++){
                parent[k][i] = parent[k-1][parent[k-1][i]];
                minLength[k][i] = Math.min(minLength[k-1][i], minLength[k-1][parent[k-1][i]]);
                maxLength[k][i] = Math.max(maxLength[k-1][i], maxLength[k-1][parent[k-1][i]]);
            }
        }
    }

    public static void initializeSparse(){
        Queue<Integer> q = new LinkedList<>();
        depth[1] = 1;
        q.add(1);

        while (!q.isEmpty()) {
            int current = q.poll();

            //부모, depth, minLength, maxLength 초기화.
            //첫번째 문제. 이거 초기화 어떻게 해줄거냐.
            //현재 초기화하는 부분은 바로위의 부모와의 거리를 저장하는 2^0부분이므로
            //그냥 바로 다음 distance를 저장시켜놓으면 된다.
            for(Node next : network[current]){
                if(depth[next.end]==0){
                    depth[next.end] = depth[current] + 1;
                    q.add(next.end);
                    parent[0][next.end] = current;
                    minLength[0][next.end] = next.weight;
                    maxLength[0][next.end] = next.weight;
                }
            }
        }

    }


}
