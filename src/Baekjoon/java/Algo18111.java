package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo18111 {
    static int N,M,B,height=0,result=0;
    static int minTime=Integer.MAX_VALUE, maxHeight=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //M*N<=25000
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(map[i][j], height);
            }
        }

        //계산방식.
        //높이 큰것부터.
        for(int i=height; i>=0; i--){
            if(findHeight(i)){
                if(result < minTime){
                    maxHeight = i;
                    minTime = result;
                }else if(result == minTime){
                    maxHeight = Math.max(maxHeight, i);
                }
            }
        }
        System.out.println(minTime + " " + maxHeight);
    }

    private static boolean findHeight(int h) {
        int higher = 0, lower = 0;
        int res = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(h>map[i][j]){
                    lower += h-map[i][j];
                }else if(h<map[i][j]){
                    higher += map[i][j]-h;
                }
            }
        }
        //땅 높이 h로 만들 수 없는 경우
        if(lower>higher + B)return false;

        //만들 수 있는 경우
        result = higher*2 + lower;
        return true;
    }
}
