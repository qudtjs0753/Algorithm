package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo14620 {
    static int[][] cost;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, minimumCost = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(isVaildIndex(i, j)){
                    visited[i][j] = true;
                    setMinimumCost(i,j, 1, sum(i,j));
                    visited[i][j] = false;
                    for(int k=0; k<4; k++){
                        visited[i+dy[k]][j+dx[k]] = false;
                    }
                }
            }
        }

        System.out.println(minimumCost);
    }


    private static void setMinimumCost(int y,int x, int count, int accCost){
        if(count==3){
            minimumCost = Math.min(accCost, minimumCost);
            return;
        }
        for(int i=y; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] || (i<=y && j<=x) ) continue;

                if(isVaildIndex(i,j)){
                    visited[i][j] = true;
                    setMinimumCost(i, j,count+1, accCost + sum(i,j));
                    visited[i][j] = false;
                    for(int k=0; k<4; k++){
                        visited[i+dy[k]][j+dx[k]] = false;
                    }
                }
            }
        }
    }

    private static boolean isVaildIndex(int y, int x){
        for(int k=0; k<4; k++){
            int nx = x +dx[k];
            int ny = y +dy[k];
            if(ny<0 || ny>=N ||
                    nx<0 || nx>=N || visited[ny][nx]){
                return false;
            }
        }
        return true;
    }

    private static int sum(int y, int x){
        int newCost = cost[y][x];
        for(int k=0; k<4; k++){
            int nx = x +dx[k];
            int ny = y +dy[k];
            visited[ny][nx] = true;
            newCost += cost[ny][nx];
        }
        return newCost;
    }
}
