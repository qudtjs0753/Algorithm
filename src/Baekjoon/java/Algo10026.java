package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: kbs
 */
public class Algo10026 {
    static int N, resultA=0, resultB=0;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1 ,0};
    static boolean[][] visitedA,visitedB;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visitedA = new boolean[N][N];
        visitedB = new boolean[N][N];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                char ch = input.charAt(j);
                map[i][j] = ch;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visitedA[i][j]){
                    resultA++;
                    bfsA(i,j);
                }
                if(!visitedB[i][j]){
                    bfsB(i,j);
                    resultB++;
                }
            }
        }

        System.out.println(resultA + " " + resultB);
    }

    private static void bfsA(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        visitedA[y][x] = true;
        q.add(new int[]{y,x});
        while(!q.isEmpty()){
            int[] current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current[1] + dx[i];
                int ny = current[0] + dy[i];

                if(nx>=N || ny>=N || nx<0 || ny<0 || visitedA[ny][nx])continue;

                if(map[current[0]][current[1]] == map[ny][nx]){
                    q.add(new int[]{ny,nx});
                    visitedA[ny][nx] = true;
                }
            }

        }
    }

    private static void bfsB(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        visitedB[y][x] = true;
        q.add(new int[]{y,x});
        while(!q.isEmpty()){
            int[] current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current[1] + dx[i];
                int ny = current[0] + dy[i];

                if(nx>=N || ny>=N || nx<0 || ny<0 || visitedB[ny][nx])continue;

                if(map[current[0]][current[1]] == map[ny][nx]
                        || map[current[0]][current[1]]=='R' && map[ny][nx]=='G'
                        || map[current[0]][current[1]]=='G' && map[ny][nx]=='R'){
                    q.add(new int[]{ny,nx});
                    visitedB[ny][nx] = true;
                }
            }
        }
    }
}
