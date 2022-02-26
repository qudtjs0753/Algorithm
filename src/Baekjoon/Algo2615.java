package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2615 {
    static int[][] map = new int[20][20];
    static int[] dx = {-1,1,1,0};
    static int[] dy = {1,0,1,1};
    static int resultX,resultY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<=19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=19; i++){
            for(int j=1; j<=19; j++){
                if(map[i][j]==0)continue;

                for(int k=0; k<4; k++){
                    if(findWinner(i,j,map[i][j],k)){
                        System.out.println(map[i][j]);
                        System.out.println(resultY + " " + resultX);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean findWinner(int startY, int startX, int color, int type) {
        int count = 0;
        int x = startX, y=startY;
        int ny= y-dy[type], nx = x-dx[type];

        //이전에 확인했던 오목인지 체크한다.
        if(ny>=1 && ny<=19 && nx>=1 && nx<=19){
            if(map[ny][nx]==color)return false;
        }

        while(map[y][x]==color){
            count++;
            y=y+dy[type];
            x=x+dx[type];
            if(y>19 || x>19 || x<1)break;
        }
        if(count==5){
            resultX = startX;
            resultY = startY;
            if(type==0){
                resultX = x+1;
                resultY = y-1;
            }
            return true;
        }
        return false;
    }
}
