package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1654 {
    static int N, K;
    static int[] line;
    public static long parametricSearch(long minValue, long maxValue){
        long midValue = (minValue + maxValue)/2;
        int count =0;
        for(int i=0; i<K; i++){
            count += line[i]/midValue;
        }
        if(minValue > maxValue) return maxValue;
        else{
            if(count>=N) return parametricSearch(midValue +1 , maxValue);
            else return parametricSearch(minValue, midValue-1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long max = 0;
        line = new int[K];
        for(int i=0; i<K; i++){
            line[i] = Integer.parseInt(br.readLine());
            if(line[i]>max) max = line[i];
        }
        System.out.println(parametricSearch(1,max));
    }
}
