package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo20366 {
    static int N;
    static long min = (long)2e9;
    static int[] snow;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        snow = new int[N];
        for(int i=0; i<N; i++){
            snow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snow);

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                checkMin(i , j);
            }
        }
        System.out.println(min);
    }

    private static void checkMin(int idx1, int idx2) {
        visited = new boolean[N];
        visited[idx1] = (visited[idx2] = true);
        int tall = snow[idx1] + snow[idx2];
        int start = 0, end = N-1;

        while(start<end){
            if(visited[start]){
                start++;
                continue;
            }
            if(visited[end]){
                end--;
                continue;
            }

            int sum = snow[start] + snow[end];

            min = Math.min(Math.abs(tall-sum), min);
            if(tall>sum){
                start++;
            }else if(tall==sum){
                return;
            }else{
                end--;
            }
        }
    }
}
