package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1647 {
    static int N,M, count = 0, result = 0;
    static Path[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Path[M];
        parent = new int[N+1];
        for(int i=0; i<=N; i++)
            parent[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[i] = new Path(v1,v2,cost);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o.cost));

        kruskal();

        System.out.println(result);
    }

    private static void kruskal() {
        for(int i=0; i<M; i++){
            if(count==N-2)return;

            Path path = arr[i];
            if(unionFind(path.v1,path.v2)){
                result+=path.cost;
                count++;
            }
        }
    }

    private static boolean unionFind(int v1, int v2){
        int parent1 = find(v1);
        int parent2 = find(v2);

        if(parent1==parent2)return false;
        else{
            if(parent1>parent2)parent[parent1] = parent2;
            else parent[parent2] = parent1;

            return true;
        }
    }

    private static int find(int v) {
        if(parent[v] == v)return v;
        else return parent[v] = find(parent[v]);
    }

    private static class Path {
        int v1,v2, cost;

        public Path(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = dist;
        }
    }
}
