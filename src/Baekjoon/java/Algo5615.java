package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @Author: kbs
 */
public class Algo5615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        while(N -- > 0){
            BigInteger input = BigInteger.valueOf(Long.parseLong(br.readLine())*2 + 1);
            if(input.isProbablePrime(10))
                count++;
        }

        System.out.println(count);
    }
}
