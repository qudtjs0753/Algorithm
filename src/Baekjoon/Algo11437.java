package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11437 {
    static int N, M,height=0;
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        findDegree(N);
        tree = new ArrayList[N+1];
        depth = new int[N+1];
        parent = new int[height+1][N+1];
        for(int i=0; i<N+1; i++)tree[i] = new ArrayList<>();
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            tree[v1].add(v2);
            tree[v2].add(v1);
        }
        M = Integer.parseInt(br.readLine());
        makeSparse();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            sb.append(getLCA(v1,v2)).append("\n");
        }
        System.out.println(sb);
    }
    static void findDegree(int n){
        for(int i=1; i<N; i*=2){
            height++;
        }
    }
    static int getLCA(int a, int b){
        if(depth[a] < depth[b]){
            return getLCA(b,a);
        }

        for(int i=0; i<=height; i++){
            //depth의 차이값 비교.
            //ex) -> a와 b의 depth차가 7이라 하면 이진수 표현시 111임.
            //이걸 뒷자리부터 하나씩 빼려고 shift 연산을 수행
            //111 & 001 -> 001 -> level 1만큼 높은 부모 찾음.
            //110 & 010 -> 010 -> level 2만큼 높은 부모 찾음.
            //100 & 100 -> 100 -> level 4만큼 높은 부모 찾음.
            if(((depth[a]-depth[b]) & (1<<i)) >= 1){
                a = parent[i][a];
            }
        }

        if(a==b)return a;

        //여기 이해 잘 안됨.
        for(int i=height; i>=0; i--){
            if(parent[i][a] != parent[i][b]){
                a= parent[i][a];
                b= parent[i][b];
            }
        }
        return parent[0][a];
    }
    static void makeSparse(){
        initializeSparse();
        for(int k=1; k<=height; k++){
            for(int i=1; i<=N;i++){
                parent[k][i] = parent[k-1][parent[k-1][i]];
            }
        }
    }

    static void initializeSparse(){
        Queue<Integer> q = new LinkedList<>();
        depth[1] = 1;
        q.add(1);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : tree[node]){
                if(depth[next]==0){
                    depth[next] = depth[node]+1;
                    q.add(next);
                    parent[0][next] = node;
                }
            }
        }
    }
}
