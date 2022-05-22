package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo3029 {
    static int[] time1 = new int[3], time2 = new int[3], result = new int[3];
    static boolean isInTime = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        for(int i=0; i<3; i++){
            time1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), ":");
        for(int i=0; i<3; i++){
            time2[i] = Integer.parseInt(st.nextToken());
        }



        for(int i=2; i>=0; i--){
            result[i] += time2[i] -time1[i];
            if(result[i]!=0)isInTime=true;
        }

        if(result[2]<0){
            result[2]+=60;
            result[1]--;
        }
        if(result[1]<0){
            result[1]+=60;
            result[0]--;
        }
        if(result[0]<0){
            result[0] += 24;
        }


        if(!isInTime){
            System.out.println("24:00:00");
            return;
        }

        System.out.format("%02d:%02d:%02d", result[0], result[1], result[2]);
    }
}
