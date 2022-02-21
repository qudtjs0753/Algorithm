package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11055 {
    static int N;
    static int[] arr;
    static int[] memo;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        memo = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = arr[i];
        }
        System.out.println(findBigestSum());
    }

    private static int findBigestSum(){
        memo[1] = arr[1];
        int max = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(arr[i]>arr[j]){
                    memo[i] = Math.max(memo[j]+arr[i], memo[i]);
                }
            }
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}
