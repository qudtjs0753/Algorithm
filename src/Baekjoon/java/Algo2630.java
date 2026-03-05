package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2630 {
    static int N;
    static int[] colorCount = new int[2];
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        slicePaper(0,N-1,0,N-1, paper[0][0]);
        System.out.println(colorCount[0]);
        System.out.println(colorCount[1]);
    }

    private static void slicePaper(int startY, int endY, int startX, int endX, int color) {
        boolean isSame = true;
        for(int i=startY; i<=endY; i++){
            for(int j=startX; j<=endX; j++){
                if(paper[i][j]!=color){
                    isSame = false;
                    break;
                }
            }
            if(!isSame)break;
        }

        if(!isSame){
            int middleY = (startY+endY)/2;
            int middleX = (startX+endX)/2;
            slicePaper(startY, middleY,
                    startX, middleX, paper[startY][startX]);
            slicePaper(middleY+1, endY,
                    startX, middleX, paper[middleY+1][startX]);
            slicePaper(startY, middleY,
                    middleX+1, endX, paper[startY][middleX+1]);
            slicePaper(middleY+1, endY, middleX+1,
                    endX, paper[middleY+1][middleX+1]);
        }else{
            colorCount[color]++;
        }
    }
}
