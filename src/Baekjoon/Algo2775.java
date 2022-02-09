package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo2775 {
    static int T,k,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            int[][] arr= new int[k+1][n+1];
            for(int i=1; i<=n; i++){
                arr[0][i]=i;
            }

            for(int i=0; i<k; i++){
                for(int j=1; j<=n; j++){
                    for(int k=1; k<=j; k++){
                        arr[i+1][j] += arr[i][k];
                    }
                }
            }

            sb.append(arr[k][n]).append("\n");
        }
        System.out.println(sb);

    }
}
