package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo2581 {
    static int N,M, result = 0, num = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        if(M==1)M+=1;

        for(int i=M; i<=N; i++){
            boolean isPrime = true;
            for(int j=2; j*j <= i; j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                result+=i;
                if(num==-1){
                    num = i;
                }
            }
        }

        if(result!=0) System.out.println(result);
        System.out.println(num);
    }
}
