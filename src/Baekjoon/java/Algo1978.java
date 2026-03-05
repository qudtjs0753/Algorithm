package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1978 {

    static int N;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(isPrime());
    }

    public static int isPrime(){
        int count = 0;
        while(N > 0){

            boolean isPrime = true;
            if(arr[N-1]==1)
                isPrime=false;

            for(int i=2; i*i<=arr[N-1]; i++){
                if(arr[N-1]%i==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)count++;
            N--;
        }
        return count;
    }
}
