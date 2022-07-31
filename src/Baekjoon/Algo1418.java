package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1418 {
    static int N,K, count=0,max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            max = 0;
            int num = i;

            for(int divisor=2; divisor*divisor<=i; divisor++){
                if(num%divisor==0){
                    max = divisor;
                    while(num%divisor==0){
                        num/=divisor;
                    }
                }
            }
            if(num!=1) max = num;
            if(max<=K){
                count++;
            }
        }

        System.out.println(count);
    }
}
