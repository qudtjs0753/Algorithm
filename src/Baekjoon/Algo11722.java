package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11722 {
    static int N;
    static int[] memo, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo =  new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = 1;
        }

        System.out.println(lis());

    }

    private static int lis(){
        int maxLength = 0;
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(arr[i]>arr[j]){
                    memo[i] = Math.max(memo[i], memo[j]+1);
                }
            }
            maxLength = Math.max(maxLength, memo[i]);
        }
        return maxLength;
    }
}
