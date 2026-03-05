package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo22945 {
    static int N,result=0;
    static int[] ability, maxIdx, minIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N];
        maxIdx = new int[10001];
        minIdx = new int[10001];
        Arrays.fill(maxIdx, -1);
        Arrays.fill(minIdx, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            ability[i] = Integer.parseInt(st.nextToken());
            for(int num=ability[i]; num>0; num--){
                if(minIdx[num]!=-1)break;
                minIdx[num] = i;
            }
        }

        for(int i=N-1; i>=0; i--){
            for(int num=ability[i]; num>0; num--) {
                if (maxIdx[num] != -1) break;
                maxIdx[num] = i;
            }
        }
        for(int i=0; i<N; i++){
            result = Math.max((maxIdx[ability[i]]-minIdx[ability[i]]-1)*ability[i],result);
        }

        System.out.println(result);
    }
}
