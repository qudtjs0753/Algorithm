package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11403 {
    static int N;
    static int[][] map;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        ans = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        floyd();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]!=0){
                    sb.append(1).append(" ");
                }else{
                    sb.append(0).append(" ");
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void floyd(){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N;k++){
                    if(map[j][k]==0 && map[j][i]!=0 && map[i][k]!=0)
                        map[j][k] = 1;
                }
            }
        }
    }

}
