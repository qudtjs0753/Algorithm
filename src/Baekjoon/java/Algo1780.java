package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1780 {
        static int N;
        static int[] count = new int[3];
        static int[][] map;

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                N = Integer.parseInt(br.readLine());
                map = new int[N][N];

                for(int i=0; i<N; i++){
                        StringTokenizer st = new StringTokenizer(br.readLine());
                        for(int j=0 ;j<N; j++){
                                map[i][j] = Integer.parseInt(st.nextToken());
                        }
                }

                checkPaper(0,0, N);

                for(int i=0;i<3; i++){
                        System.out.println(count[i]);
                }
        }

        private static void checkPaper(int startY,int startX,int size) {
                int kind = map[startY][startX];
                for(int i=startY; i<startY+size; i++){
                        for(int j=startX; j<startX+size; j++){
                                if(map[i][j]!=kind){
                                        slicePaper(startY, startX, size/3);
                                        return;
                                }
                        }
                }
                count[kind+1]++;
        }

        private static void slicePaper(int startY,int startX ,int size){
                checkPaper(startY, startX, size);
                checkPaper(startY+size, startX, size);
                checkPaper(startY+size*2, startX, size);
                checkPaper(startY, startX+size, size);
                checkPaper(startY+size, startX+size, size);
                checkPaper(startY+size*2, startX+size, size);
                checkPaper(startY, startX+size*2, size);
                checkPaper(startY+size, startX+size*2, size);
                checkPaper(startY+size*2, startX+size*2, size);
        }
}
