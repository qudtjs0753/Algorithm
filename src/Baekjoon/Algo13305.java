package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo13305 {
    static int N;
    static long minSum=0;
    static long[] city, dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        city = new long[N];
        dist = new long[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            city[i] = Long.parseLong(st.nextToken());
        }

        int end=1;
        long oil = city[0];
        int accDist = 0;
        while(end<N){
            accDist+=dist[end-1];
            if(city[end]<oil){
                minSum += accDist*oil;
                oil = city[end];
                accDist=0;
            }
            end++;
        }
        if(accDist!=0){
            minSum+=oil*accDist;
        }
        System.out.println(minSum);
    }
}

