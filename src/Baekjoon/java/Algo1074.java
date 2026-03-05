package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1074 {
    static int N,r,c, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int maxRow = (int)Math.pow(2, N);
        findOrder(0, 0, maxRow-1, maxRow-1);
        System.out.println(result);


    }

    private static void findOrder(int startR, int startC, int endR, int endC) {
        int count = 0;
        if(endR-startR<=1 && endC-startC<=1){
            for(int i=0;i<2; i++){
                for(int j=0; j<2; j++){
                    if(startR+i==r && startC+j==c){
                        result+=count;
                        return;
                    }
                    count++;
                }
            }
        }else{
            for(int i=0;i<2; i++){
                for(int j=0; j<2; j++){
                    int startRow = startR + i*(endC-startC+1)/2;
                    int startCol = startC + j*(endR-startR+1)/2;
                    int endRow = startRow + (endR-startR+1)/2-1;
                    int endCol = startCol + (endR-startR+1)/2-1;
                    if(r>=startRow && r<=endRow && c>=startCol && c<=endCol){
                         result += (endC-startC+1)/2*(endR-startR+1)/2*count;
                         findOrder(startRow,startCol,endRow,endCol);
                         return;
                    }
                    count++;
                }
            }
        }
    }
}
