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
public class Algo11438 {
    static int[][] parent;
    static int[] depth;
    static ArrayList<Integer>[] vertex;
    static int N, M, logN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        getLogN();
        parent = new int[logN + 1][N + 1];
        vertex = new ArrayList[N+1];
        depth = new int[N+1];
        for (int i = 0; i <= N; i++) vertex[i] = new ArrayList<>();

        for(int i=1; i<=N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            vertex[node1].add(node2);
            vertex[node2].add(node1);
        }
        makeSparse();

        M = Integer.parseInt(br.readLine());
        for(int i=1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            sb.append(getLCA(node1, node2)).append("\n");
        }
        System.out.println(sb);
    }

    private static void getLogN() {
        logN = 0;
        for(int k=1; k<N; k*=2){
            logN++;
        }
    }

    //나머지 parent를 채움.
    private static void makeSparse() {
        initializeSparse();
        for(int i=1; i<=logN; i++){
            for(int j=1; j<=N; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }

    //depth 정리하고 parent[0] 가로줄을 초기화
    //이후 depth의 차이를 이진수로 체크 한 뒤
    //2^k승 형태로 나타내는 것임 -> parent[k] -> 2^k 레벨 위의 부모.
    private static void initializeSparse(){
        Queue<Integer> q = new LinkedList<>();
        depth[1] = 1;
        q.add(1);

        while(!q.isEmpty()){
            int current = q.poll();
            for(int next : vertex[current]){
                if(depth[next]==0){
                    depth[next]=depth[current] + 1;
                    parent[0][next] = current;
                    q.add(next);
                }
            }
        }
    }

    //구한 depth를 토대로 2^k승씩 올라가면서 확인하면 됨.
    static int getLCA(int nodeA, int nodeB){
        if(depth[nodeA] < depth[nodeB]){
            return getLCA(nodeB, nodeA);
        }
        //레벨을 맞춰준다.

        for(int i=0; i<=logN; i++){
            if(((depth[nodeA] - depth[nodeB]) & (1<<i)) >= 1){
                nodeA = parent[i][nodeA];
            }
        }
        //이후 공통 조상을 찾는다. 이때 상승은 2^n으로.
        //동일해진경우. 그 동일선상 혹은 아래에 LCA가 존재한다.

        if(nodeA==nodeB){
            return nodeA;
        }


        //최종적으로 LCA 바로 밑칸까지만 올라감.
        for(int i=logN; i>=0; i--){
            if(parent[i][nodeA] != parent[i][nodeB]){
                nodeA = parent[i][nodeA];
                nodeB = parent[i][nodeB];
            }
        }
        return parent[0][nodeA];
    }


}
