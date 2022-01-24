package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11657 {
    static int N, M;
    static ArrayList<Bus>[] info;
    static long[] distance;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        distance = new long[N+1];
        distance[1] = 0;
        for(int i=2; i<=N; i++)distance[i] = INF;

        info = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) info[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            info[start].add(new Bus(end, weight));
        }
        if(bellmanFord()){
            for(int i=2; i<=N; i++){
                if(distance[i]==INF){
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(distance[i]).append("\n");
                }
            }
        }else{
            sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }

    static boolean bellmanFord(){
        boolean isUpdated=false;

        //작업을 N번 한다.
        for (int iter = 1; iter<=N; iter++) {
            isUpdated = false;
            //최소거리 찾는 과정
            for(int here=1; here<=N; here++){
                for(int i=0; i<info[here].size(); i++){
                    if(distance[here]==INF)break;
                    int placeToGo = info[here].get(i).end;
                    long cost = info[here].get(i).weight;

                    if(distance[placeToGo]>distance[here] + cost){
                        isUpdated= true;
                        distance[placeToGo] = distance[here] + cost;
                    }
                }
            }
            if(!isUpdated)break;
        }
        //만약 N번 돌았는데도 업데이트가 되면 이는 음수가중치가 존재한다는 것을 말한다.
        if(isUpdated) return false;
        return true;
    }

    private static class Bus {
        int end;
        long weight;

        public Bus(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

    }
}
