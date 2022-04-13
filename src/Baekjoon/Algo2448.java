package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: kbs
 */
public class Algo2448 {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int row = 2*N-1;
        map = new char[N][row];
        for(int i=0; i<N; i++){
            Arrays.fill(map[i], ' ');
        }
        createTriangle(N, 0, row/2);

        for(int i=0; i<N; i++){
            for(int j=0; j<row; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void createTriangle(int num, int y, int x) {
        if(num==3){
            map[y][x] = '*';
            map[y+1][x-1] = map[y+1][x+1] = '*';
            for(int i=0; i<5; i++){
                map[y+2][x-2+i]='*';
            }
        }else {
            createTriangle(num/2, y, x);
            createTriangle(num/2, y+num/2, x-num/2);
            createTriangle(num/2, y+num/2, x+num/2);
        }
    }
}
