package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo16918 {
    static int R,C,N;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static char[][] map,memo;
    static int[][] count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        memo = new char[R][C];
        count = new int[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
               map[i][j] = str.charAt(j);
            }
        }

        if(N<=1){
            makeOutput();
            System.out.println(sb);
            return;
        }else{
            takeState();
            makeOutput();
            System.out.println(sb);
        }

    }

    private static void takeState() {
        int time = 1;

        while(true){
            pushBomb();
            time++;
            if(time>=N)break;

            popBomb();
            time++;
            if(time>=N)break;
        }
    }

    private static void makeOutput(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
    }

    private static void pushBomb(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                memo[i][j] = map[i][j];
                if(map[i][j] == '.')
                    map[i][j] = 'O';
            }
        }
    }

    private static void popBomb(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(memo[i][j]=='O'){
                    map[i][j] = '.';
                    for(int k=0; k<4; k++){
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if(nx<0 || nx>=C || ny<0 || ny>=R)continue;
                        map[ny][nx] = '.';
                    }
                }
            }
        }

    }
}
