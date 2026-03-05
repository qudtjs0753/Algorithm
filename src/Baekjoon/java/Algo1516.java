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
public class Algo1516 {
    static int N;
    static int[] inDegree,time;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        inDegree = new int[N + 1];
        graph = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();

        int input;
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                input = Integer.parseInt(st.nextToken());
                if(input==-1) break;
                graph[input].add(i);
                graph[i].add(input);
                inDegree[i]++;
            }
        }
        topologySort();
        for(int i=1; i<=N; i++){
            sb.append(time[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void topologySort(){
        //위상정렬을 이용하되, 순서가 없는. 즉 inDegree가 동일한녀석들은 동시에
        //만들 수 있음에 유의
        Queue<Integer> q = new LinkedList<>();
        //inDegree 0인애들 큐에 추가하고 -1해줌.
            //얘네는 더해지는거 없이 바로 없어져야하므로
        for(int i=1; i<=N; i++)
            if(inDegree[i]==0){
                q.add(i);
                inDegree[i]--;
            }


        while(!q.isEmpty()){
            //필요한 건물이 2개 이상 있는 경우를 고려해야함.
            //maxTime은 이들 중 시간이 가장 긴 녀석을 고를때 사용.
            //왜 시간이 제일 긴 애를 고름?
            //동시에 여러개 지을땐 시간 가장 긴 녀석 골라야함.
            int maxTime = 0;
            int current = q.poll();
            for(int structure : graph[current]){
                inDegree[structure]--;
                //만약 건물에 방문했다면 queue에 추가.
                if(inDegree[structure]==0)
                    q.add(structure);
                //두번이상 방문시엔 maxTime에 계산한 시간을 추가.
                if(inDegree[structure]<0)
                    maxTime = Math.max(maxTime, time[structure]);
            }
            //처음 방문했던 경우 필요 건물을 만드는데 필요한 최대 시간을 더해 저장.
            if(inDegree[current]==0){
                time[current] += maxTime;
                inDegree[current]--;
            }


        }
    }
}
