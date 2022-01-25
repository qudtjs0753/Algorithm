package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11266 {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] order;
    static boolean[] isCutVertex;

    static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        order = new int[V+1];
        for(int i=0; i<=V; i++)order[i] = -1;
        isCutVertex = new boolean[V+1];
        graph = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        for(int i=1; i<=V; i++){
            if(order[i] == -1)   findCutVertex(i, true);
        }
        int relateCount = 0;
        for(int i=1; i<=V; i++){
            if(isCutVertex[i]){
               sb.append(i).append(" ");
               relateCount++;
            }
        }
        System.out.println(relateCount);
        if(relateCount>0)
            System.out.println(sb);
    }

    //반환값은 해당 서브트리에서 역방향 간선으로 갈 수 있는 정점중
    //가장 일찍 발견된 정점의 발견 시점.
    static int findCutVertex(int current, boolean isRoot){
        //그래프가 주어질 때 연결그래프가 아닐 수 있음에 유의하라.
        //발견 순서 기록
        order[current] = counter++;
        int ret = order[current];
        //루트인 경우 절단점 판정 위해 자손 서브트리의 개수를 센다.
        int children = 0;
        for(int child : graph[current]){
            if(order[child]==-1){
                children++;
                //이 subtree에서 갈 수 있는 가장 높은 정점의 번호.
                int subtree = findCutVertex(child, false);

                //root가 아니며 subtree가 갈 수 있는 최대 높이가 현재 노드의 순서보다 높으면 여긴 단절점.
                if(!isRoot && subtree >= order[current])
                    isCutVertex[current] = true;
                ret = Math.min(ret, subtree);
            }else{
                ret = Math.min(ret, order[child]);
            }
        }

        //루트인 경우 절단점 판정은 서브트리의 개수 -> 2개 이상이어야 절단점이 된다.
        if(isRoot) isCutVertex[current] = (children>=2);

        return ret;
    }
}
