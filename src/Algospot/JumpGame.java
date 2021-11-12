package Algospot;

import java.io.*;
import java.util.StringTokenizer;

public class JumpGame {
    static int n,c;
    static int[][] board = new int[100][100];
    static int[][] cache = new int[100][100];

    public static int jump(int y, int x){
        if(y>=n || x>=n)return 0;
        if(y == n-1 && x == n-1) return 1;

        //memoization
        if(cache[y][x] != -1) return cache[y][x];
        int jumpSize = board[y][x];
        return cache[y][x] = (jump(y + jumpSize, x)!=0 || jump(y, x + jumpSize)!=0) ? 1 : 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        c = Integer.parseInt(br.readLine());
        for(int k=0; k<c; k++){
            n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                    cache[i][j] = -1;
                }
            }
            int result = jump(0,0);
            if(result == 1) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
