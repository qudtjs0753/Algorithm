package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1107 {
    static final int MAX_VALUE = 1000001;
    static int N, M, min = MAX_VALUE;
    static boolean[] isBroken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if(M>=1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                isBroken[Integer.parseInt(st.nextToken())]=true;
            }
        }


        if(N==100){
            System.out.println(0);
            return;
        }

        min = Math.abs(N-100);

        for(int i=0; i<10; i++){
            if(isBroken[i])continue;
            getMinimumPush(1, i);
        }
        System.out.println(min);
    }

    private static void getMinimumPush(int depth, int num) {
        if(depth>=7 || num>=MAX_VALUE)return;
        int count = countDigit(num);
        min = Math.min(min, count + Math.abs(num-N));

        for(int i=0; i<10; i++){
            if(isBroken[i])continue;
            getMinimumPush(depth+1, num*10 + i);
        }


    }

    private static int countDigit(int num) {
        int digit = 1;

        num/=10;

        while(num!=0){
            num/=10;
            digit++;
        }

        return digit;
    }
}
