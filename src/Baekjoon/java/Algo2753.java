package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo2753 {
    static int year;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        year = Integer.parseInt(br.readLine());

        if(year%400==0){
            System.out.println(1);
        }else if(year%100==0){
            System.out.println(0);
        }else if(year%4==0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
