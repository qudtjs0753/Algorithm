package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo3830 {
    static int N,M;
    static Sample[] vertex;
    static class Sample {
        int parent;
        long weight;

        public Sample(int parent, long weight) {
            this.parent = parent;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String operation;
        int low, high;
        long weight;
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0)break;

            vertex = new Sample[N+1];
            for(int i=0; i<=N; i++) vertex[i] = new Sample(i,0);
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                operation = st.nextToken();
                low = Integer.parseInt(st.nextToken());
                high = Integer.parseInt(st.nextToken());
                if(operation.equals("!")){
                    weight = Integer.parseInt(st.nextToken());
                    union(low,high,weight);
                }else {
                    if(find(low)==find(high)){
                        long weightDiff = vertex[high].weight - vertex[low].weight;
                        sb.append(weightDiff).append("\n");
                    }else{
                        sb.append("UNKNOWN").append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }


    //무게를 기준으로 unionfind -> 무게가 상대적으로 낮은친구일수록
    private static void union(int low, int high, long weight) {
        //여기서 우선 루트 이전까진 압축을 진행.
        //압축하고나서 갱신을 어떻게해야하지?
        int parentLow = find(low);
        int parentHigh = find(high);

        if(parentLow == parentHigh) return;

        //union 및 root에 대한 weight 재설정.
        vertex[parentHigh].weight = vertex[low].weight - vertex[high].weight + weight;
        vertex[parentHigh].parent = parentLow;
    }

    //find와 update 수리 필요.
    //어떻게 압축시키면서 더해줄까?
    private static int find(int a){
        if(a== vertex[a].parent)return a;
        else{
            int temp = find(vertex[a].parent);
            vertex[a].weight += vertex[vertex[a].parent].weight;
            return vertex[a].parent = temp;
        }
    }


}
