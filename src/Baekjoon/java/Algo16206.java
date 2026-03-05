package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo16206 {
    static int N,M,result = 0, canMade=0, sliceCount=0;
    static ArrayList<Integer> efficientCakes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int rollCake = Integer.parseInt(st.nextToken());

            if(rollCake%10==0){
                efficientCakes.add(rollCake);
            }else if(rollCake>10){
                canMade += rollCake/10;
            }
        }

        Collections.sort(efficientCakes);

        for(int rollCake : efficientCakes){
            int nextSlice = (rollCake/10) -1;
            if(sliceCount + nextSlice <= M){
                sliceCount += nextSlice;
                result += nextSlice+1;
            }else{
                result += M-sliceCount;
                sliceCount = M;
            }
        }

        if(sliceCount<M){
            if(canMade>=M-sliceCount){
                result += M-sliceCount;
            }else{
                result += canMade;
            }
        }

        System.out.println(result);
    }
}
