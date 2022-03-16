package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo22869 {
    static int N,K;
    static int[] stones;
    static boolean[] memo;
    static final int MAX = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        memo = new boolean[N+1];
        stones = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            stones[i] = Integer.parseInt(st.nextToken());
        }
        memo[1] = true;
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                if(memo[i] && (j-i)*(1 + Math.abs(stones[j]-stones[i]))<=K){
                    memo[j]=true;
                }
            }
        }

        if(memo[N]){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
