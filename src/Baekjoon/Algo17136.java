package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo17136 {

    static int result = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int[] count = new int[6];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        arr = new int[10][10];
        visit = new boolean[10][10];

        Arrays.fill(count, 5);

        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0,0, 0);

        if(result==Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    private static void backtracking(int y, int x, int value) {
        if(value>=result) return;
        //x값이 끝에 도달했으면 다음 y로 넘어간다.
        if(x==10) {
            backtracking(y+1,0, value);
            return;
        }

        //y가 끝에 도달했다는 것은 모든 지점에 방문했다는 것.
        if(y==10) {
            result = Math.min(value,result);
            return;
        }

        if(arr[y][x]==0 || visit[y][x]) {
            backtracking(y, x+1, value);
            return;
        }

        for(int i=1; i<=5; i++) {
            if(count[i]==0) continue;
            if(isInvalid(y,x,i)) continue;
            count[i] -= 1;
            mark(y,x,i,0);
            backtracking(y, x+1, value+1);
            mark(y,x,i,1);
            count[i] += 1;
        }
    }

    //표기했다가 취소하는 과정.
    private static void mark(int y, int x, int length,int num) {
        for(int i=y; i<y+length; i++) {
            for(int j=x; j<x+length; j++) {
                arr[i][j] = num;
            }
        }
    }

    private static boolean isInvalid(int y, int x, int length) {
        if(y+length > 10 || x+length > 10) return true;
        for(int i=y; i<y+length; i++) {
            for(int j=x; j<x+length; j++) {
                if(arr[i][j]==0) {
                    return true;
                }
            }
        }
        return false;
    }
}
