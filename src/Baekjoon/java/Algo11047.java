package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11047 {
    static int N,K, count=0;
    static int[] coin;
    public static int findCoinGreedy(){
        for(int i=N-1; i>=0; i--){
            if(K==0)break;
            while(K>=coin[i]){
                K-=coin[i];
                count+=1;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for(int i=0; i<N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findCoinGreedy());
    }
}
