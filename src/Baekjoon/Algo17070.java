package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo17070 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(movePipe(1, 0, 1));
    }

    //status1:수평 status2:대각선 status3:수직
    private static int movePipe(int status, int y, int x){

        int ret = 0;
        if(y==N-1 && x==N-1){
            return 1;
        }
        int ny = y+1;
        int nx = x+1;

        boolean canGoHorizontalDirection = y<=N-1 && x<=N-2 && map[y][nx]==0;
        boolean canGoDiagonalDirection = ny<=N-1 && nx<=N-1 && map[y][nx]==0 && map[y][nx]==map[ny][nx] && map[ny][nx]==map[ny][x];
        boolean canGoVerticalDirection = ny<=N-1 && x<=N-1 && map[ny][x]==0;
        if(status==1){
            if(canGoHorizontalDirection){
                ret += movePipe(1, y, nx);
            }
            if(canGoDiagonalDirection){
                ret += movePipe(2, y+1, x+1);
            }
        }else if(status==2){
            if(canGoHorizontalDirection){
                ret += movePipe(1, y, nx);
            }
            if(canGoVerticalDirection){
                ret += movePipe(3, ny, x);
            }
            if(canGoDiagonalDirection){
                ret += movePipe(2, y+1, x+1);
            }
        }else{
            if(canGoVerticalDirection){
                ret += movePipe(3, ny, x);
            }
            if(canGoDiagonalDirection){
                ret += movePipe(2, y+1, x+1);
            }
        }

        return ret;
    }
}
