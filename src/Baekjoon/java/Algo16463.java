package Baekjoon;

import java.io.*;

public class Algo16463 {

    static StringBuilder sb = new StringBuilder();
    static int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //0, 1, 2, 3, 4 (월, 화, 수, 목, 금)
        int ans = 0, sum = 13;

        for(int year=2019; year<=N; year++) {
            for(int i=1; i<=12; i++) {
                if(sum%7==4) ans++;

                sum += month[i];

                if(i==2 && (year%400==0 || (year%4==0 && year%100!=0))) {
                    sum++;
                }
            }
        }

        System.out.println(ans);
    }
}
