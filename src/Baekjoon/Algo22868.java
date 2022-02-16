package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo22868 {
    static int N,M,S,E,result=0;
    static ArrayList<Integer>[] map;
    static int[] depth,path;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        depth = new int[N + 1];
        map = new ArrayList[N+1];
        path = new int[N + 1];
        checked = new boolean[N + 1];

        for(int i=0; i<N+1; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v2].add(v1);
            map[v1].add(v2);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i=0; i<N+1; i++)Collections.sort(map[i]);
        bfs(S,E);
        makePath();
        bfs(E,S);

        System.out.println(depth[S]);
    }


    private static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        checked[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : map[current]) {
                if(!checked[next]){
                    checked[next] = true;
                    depth[next]= depth[current]+1;
                    //path는 이전 경로 저장할때 사용.
                    path[next] = current;
                    q.add(next);
                }
            }
        }
    }

    private static void makePath(){
        Arrays.fill(checked, false);
        checked[E] = true;
        int last = path[E];
        while(last>0){
            checked[last] = true;
            last = path[last];
        }
        checked[S] = false;
    }

}
