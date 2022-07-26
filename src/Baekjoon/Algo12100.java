package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo12100 {
    static int N, result = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<4; i++){
            moveBlock(i,1, map);
        }

        System.out.println(result);
    }

    private static void moveBlock(int direction, int depth, int[][] original) {
        if(depth==6){
            findMaximum(original);
            return;
        }

        boolean[][] isMerged = new boolean[N][N];
        int[][] copy = new int[N][N];

        //copy
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                copy[i][j] = original[i][j];
            }
        }

        //move
        switch (direction){
            case 0:
                moveLeft(copy,isMerged);
                break;
            case 1:
                moveRight(copy,isMerged);
                break;
            case 2:
                moveUpward(copy,isMerged);
                break;
            case 3:
                moveDownward(copy,isMerged);
                break;
        }

        //next
        for(int i=0; i<4; i++){
            moveBlock(i, depth+1, copy);
        }
    }

    private static void moveRight(int[][] arr, boolean[][] isMerged) {
        for(int i=0; i<N; i++){
            for(int j=N-2; j>=0; j--){
                int currentPos = j;
                while(currentPos < N-1){
                    int newPos = currentPos+1;
                    if(arr[i][newPos]==0){
                        arr[i][newPos]=arr[i][currentPos];
                        arr[i][currentPos] = 0;
                        currentPos = newPos;
                    }else if(!isMerged[i][newPos] && arr[i][newPos]==arr[i][currentPos]){
                        arr[i][newPos] = arr[i][currentPos]+arr[i][newPos];
                        isMerged[i][newPos] = true;
                        arr[i][currentPos] = 0;
                        break;
                    }else break;
                }
            }
        }
    }

    private static void moveDownward(int[][] arr, boolean[][] isMerged) {
        for(int i=0; i<N; i++){
            for(int j=N-2; j>=0; j--){
                int currentPos = j;
                while(currentPos < N-1){
                    int newPos = currentPos+1;
                    if (arr[newPos][i] == 0) {
                        arr[newPos][i] = arr[currentPos][i];
                        arr[currentPos][i] = 0;
                        currentPos = newPos;
                    } else if (!isMerged[newPos][i] && arr[newPos][i] == arr[currentPos][i]) {
                        arr[newPos][i] = arr[currentPos][i] + arr[newPos][i];
                        isMerged[newPos][i] = true;
                        arr[currentPos][i] = 0;
                        break;
                    } else break;

                }
            }
        }
    }

    private static void moveLeft(int[][] arr, boolean[][] isMerged) {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int currentPos = j;
                while (currentPos > 0) {
                    int newPos = currentPos - 1;
                    if (arr[i][newPos] == 0) {
                        arr[i][newPos] = arr[i][currentPos];
                        arr[i][currentPos] = 0;
                        currentPos = newPos;
                    } else if (!isMerged[i][newPos] && arr[i][newPos] == arr[i][currentPos]) {
                        arr[i][newPos] = arr[i][currentPos] + arr[i][newPos];
                        isMerged[i][newPos] = true;
                        arr[i][currentPos] = 0;
                        break;
                    } else break;
                }
            }
        }
    }

    private static void moveUpward(int[][] arr, boolean[][] isMerged){
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int currentPos = j;
                while (currentPos > 0) {
                    int newPos = currentPos - 1;
                    if (arr[newPos][i] == 0) {
                        arr[newPos][i] = arr[currentPos][i];
                        arr[currentPos][i] = 0;
                        currentPos = newPos;
                    } else if (!isMerged[newPos][i] && arr[newPos][i] == arr[currentPos][i]) {
                        arr[newPos][i] = arr[currentPos][i] + arr[newPos][i];
                        isMerged[newPos][i] = true;
                        arr[currentPos][i] = 0;
                        break;
                    } else break;
                }
            }
        }
    }







    private static void findMaximum(int[][] arr){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result = Math.max(arr[i][j], result);
            }
        }
    }
}
