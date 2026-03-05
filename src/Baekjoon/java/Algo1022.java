package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1022 {
    static int r1, r2, c1, c2, count = 0;
    static int maxDigit = 0;
    static int[][] map, digit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        map = new int[r2-r1+1][c2-c1+1];
        digit = new int[r2-r1+1][c2-c1+1];



        int border = (r2-r1+1)*(c2-c1+1);
        int y=0, x=0, toGo = 1, value=1;

        while(count<border){
            for(int i=0; i<toGo; i++){
                if(y>=r1 && y<=r2 && x>=c1 && x<=c2){
                    count++;
                    map[y-r1][x-c1] = value;
                }
                if(toGo%2==1)x++;
                else x--;
                value++;
            }
            for(int i=0; i<toGo; i++){
                if(y>=r1 && y<=r2 && x>=c1 && x<=c2){
                    count++;
                    map[y-r1][x-c1] = value;
                }
                if(toGo%2==1)y--;
                else y++;
                value++;
            }
            toGo++;
        }

        for(int i=0; i<map[0].length; i++){
            for(int j=0; j<map.length; j++){
                int num = map[j][i], ct = 1;
                while(num>0){
                    num/=10;
                    ct++;
                }
                digit[j][i] = ct;
                maxDigit = Math.max(maxDigit, ct);
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                for(int k=0; k<maxDigit-digit[i][j]; k++){
                    sb.append(" ");
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
