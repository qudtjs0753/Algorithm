package Algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution_BoardCover {
     static int[][][] coverType = {
             {{0,0},{1,0},{0,1}},
            {{0,0},{0,1},{1,1}},
             {{0,0}, {1,0},{1,1}},
            {{0,0},{1,0},{1,-1}}
    };
     //delta = 1이면 덮고, -1이면 덮었던 블록을 없앤다.
     public static boolean set(int[][] board, int y, int x, int type, int delta){
         boolean ok = true;
         for(int i=0; i< 3; i++){
             int ny = y + coverType[type][i][0];
             int nx = x + coverType[type][i][1];
             if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length)
                 ok = false;
             else if((board[ny][nx] += delta) > 1)
                 ok = false;
         }
         return ok;
     }

     public static int cover(int[][] board){
         int y= -1;
         int x= -1;
         for(int i=0; i<board.length; i++){
             for(int j=0; j<board[0].length; j++){
                 if(board[i][j] == 0) {
                     y = i;
                     x = j;
                     break;
                 }
             }
             //여기.. 중요.
             if(y != -1){
                 break;
             }
         }
         if( y == -1) return 1;
         int ret = 0;
         for(int type=0; type<4; type++){
             if(set(board, y, x, type, 1))
                 ret += cover(board);
             set(board, y, x, type, -1);
         }
         return ret;
     }

     public static void main(String[] args){
         try{
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             int c = Integer.parseInt(br.readLine());
             int h,w;
             String[] input;
             String str="";
             int count = 0;
             for(int i=0; i<c; i++){
                 input = br.readLine().split(" ");
                 h = Integer.parseInt(input[0]);
                 w = Integer.parseInt(input[1]);
                 int[][] board = new int[h][w];
                 count = 0;
                 //#: 검은칸, . : 흰칸
                 for(int j=0; j<h; j++){
                     str = br.readLine();
                     for(int k=0; k<w; k++){
                         if(str.charAt(k) == '#')
                             board[j][k] = 1;
                         else{
                             board[j][k] = 0;
                             count++;
                         }
                     }
                 }
                 if(count%3!=0){
                     System.out.println(0);
                 }
                 else{
                     System.out.println(cover(board));
                 }
             }

         }catch(IOException e){
             e.printStackTrace();
         }
     }
}
