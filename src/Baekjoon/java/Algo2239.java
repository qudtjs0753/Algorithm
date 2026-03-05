package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo2239 {
    static boolean isAnswered = false;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<int[]> list = new ArrayList<>();

    static int[][] map = new int[9][9];
    static boolean[][] row = new boolean[9][10],col = new boolean[9][10];
    static boolean[][][] box = new boolean[3][3][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++){
            String input = br.readLine();
            for(int j=0; j<9; j++){
                int num = input.charAt(j) - '0';
                map[i][j] = num;
                col[i][num] = row[j][num] = box[i/3][j/3][num] = true;
                if(num==0) list.add(new int[]{i, j});
            }
        }

        for(int i=1; i<=9; i++){
            sudoku(0, i);
        }

        System.out.println(sb);
    }

    private static void sudoku(int idx, int num) {
        if(isAnswered)return;

        if(idx==list.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            isAnswered = true;
            return;
        }

        int y = list.get(idx)[0];
        int x = list.get(idx)[1];

        if(!col[y][num] && !row[x][num] && !box[y/3][x/3][num]){
            map[y][x] = num;
            col[y][num] = row[x][num] = box[y/3][x/3][num] = true;
            for(int i=1; i<=9; i++){
                sudoku(idx+1, i);
            }
            col[y][num] = row[x][num] = box[y/3][x/3][num] = false;
        }
    }
}
