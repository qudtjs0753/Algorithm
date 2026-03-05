package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo3151 {
    static int[] skillPoint = new int[20001];
    static int N;
    static long result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            skillPoint[input+10000]++;
        }

        int start = 0;

        while(skillPoint[start]==0) start++;

        while(start<=20000){
            for(int i=20000; i>=start; i--){
                int findNum = 30000-start-i;

                if(findNum>i)break;
                if( findNum<start || skillPoint[findNum]==0 || skillPoint[i]==0)continue;
                calculate(start, i, findNum);
            }
            start++;
            while(start<=20000 && skillPoint[start]==0) start++;
        }

        System.out.println(result);
    }

    private static void calculate(int start, int end, int findNum) {
        //3개 다 같은 경우
        if(start==end&&start==findNum){
            result += (long) skillPoint[start] *(skillPoint[start]-1)*(skillPoint[start]-2)/6;
        }
        //2개 같은 경우
        else if(start==findNum){
            result += (long) skillPoint[start] *(skillPoint[start]-1)/2 * skillPoint[end];
        }else if(end==findNum){
            result += (long) skillPoint[end] *(skillPoint[end]-1)/2 * skillPoint[start];
        }
        //다 다른 경우.
        else {
            result += (long) skillPoint[start] *skillPoint[end]*skillPoint[findNum];
        }
    }
}
