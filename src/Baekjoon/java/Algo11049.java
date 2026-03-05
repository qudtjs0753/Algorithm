package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11049 {
    static int N;
    static int[] matrices;
    static int[][] T;
    static long[][] S;

    public static long findMinimumMultiply(){
        int j;
        for(int d = 1; d<=N-1; d++)
            for(int i=1; i<=N-d; i++){
                j = i +d;
                S[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    if(S[i][k] + S[k+1][j] + matrices[i-1]*matrices[k]*matrices[j]<S[i][j] ){
                        S[i][j] = S[i][k]+S[k+1][j]+matrices[i-1]*matrices[k]*matrices[j];
                        T[i][j] = k;
                    }
                }
            }
        return S[1][N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrices = new int[N+1];
        S = new long[N+1][N+1];
        T = new int[N+1][N+1];
        for(int i=0; i<=N; i++)
            for(int j=0; j<=N; j++)
                S[i][j] = Integer.MAX_VALUE;
        for(int i=0; i<=N; i++)
            S[i][i] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        matrices[0] = Integer.parseInt(st.nextToken());
        matrices[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            matrices[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(findMinimumMultiply());
    }
}
