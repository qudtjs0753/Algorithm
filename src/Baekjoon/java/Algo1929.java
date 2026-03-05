package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1929 {
    static int M,N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        findPrime();
        System.out.print(sb);
    }

    static void findPrime(){
        int n=M;
        boolean isPrime;
        while(n<=N){
            if(n==1){
                n++;
                continue;
            }
            isPrime = true;
            for(int i=2; i*i<= n; i++){
                if(n%i==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)sb.append(n).append("\n");
            n++;
        }

    }
}
