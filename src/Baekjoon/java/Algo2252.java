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
public class Algo2252 {
    static int N, M;
    static int[] inDegree,result;
    static ArrayList<Integer>[] root;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        root = new ArrayList[N+1];
        for(int i=0; i<=N; i++)root[i] = new ArrayList<>();
        inDegree = new int[N+1];
        visited = new boolean[N+1];
        result = new int[N+1];

        int x, y;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x=  Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            //큰 녀석의 아래에 작은 녀석을 추가.
            root[x].add(y);
            inDegree[y]++;
        }
        topologySort();
        System.out.println(sb);
    }


    static void topologySort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        //N명에게 방문.
        for(int i=1; i<=N; i++){
            if(queue.isEmpty()){
                System.out.println(1);
                return;
            }
            int x = queue.poll();
            result[i] = x;
            for(int j=0; j<root[x].size(); j++){
                int y = root[x].get(j);

                //진입차수 0이면 큐에 삽입
                if(--inDegree[y]==0)
                    queue.add(y);
            }
        }
        for(int i=1; i<=N; i++)
            sb.append(result[i]).append(" ");

    }
}
