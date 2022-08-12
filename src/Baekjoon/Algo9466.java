package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo9466 {
    static int T,N, count;
    static int[] arr;
    static boolean[] checkCycle;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            checkCycle = new boolean[N+1];
            visit = new boolean[N+1];

            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                if(!visit[i]){
                    findCycle(i);
                }
            }

            sb.append(N-count).append("\n");
        }

        System.out.println(sb);
    }

    private static void findCycle(int current) {

        visit[current] = true;

        int next = arr[current];

        if(!visit[next]){
            findCycle(next);
        }

        if(visit[next] && !checkCycle[next]){
            int path = arr[next];
            while(next!=path){
                count++;
                path = arr[path];
            }
            count++;
        }


        checkCycle[current] = true;
    }
}
