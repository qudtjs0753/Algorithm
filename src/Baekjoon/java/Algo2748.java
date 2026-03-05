package Baekjoon;

import java.util.Scanner;

/**
 * @Author: kbs
 */
public class Algo2748 {
    public static long fibo(long one, long two, int n){
        if(n==0)return one;
        else return fibo(two, one+two, n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(0, 1, n));

    }
}
