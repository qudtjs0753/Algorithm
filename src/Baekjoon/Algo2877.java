package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Author: kbs
 */
public class Algo2877 {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());


        while(K!=0){
            if(K%2==1){
                sb.append(4);
            }else{
                sb.append(7);
            }
            K=(K-1)/2;
        }

        System.out.println(sb.reverse());

    }
}
