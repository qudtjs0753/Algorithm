package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */

public class Algo2638 {
    static int N,M, remain=0, time=0;
    static int[] dy = {-1,0,1,0}, dx = {0,1,0,-1};
    static int[][] map;
    static boolean[][] isAir;
    static Queue<int[]> q, air;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isAir = new boolean[N][M];
        air = new ArrayDeque<>();
        q = new ArrayDeque<>();
        air.add(new int[]{0,0});

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)remain++;
            }
        }

        while(remain>0){
            findAir();
            findCheese();
            meltingCheese();
            time++;
        }

        System.out.println(time);
    }

    private static void findAir() {
        while(!air.isEmpty()){
            int[] current = air.poll();
            int y = current[0];
            int x = current[1];
            if(map[y][x] == 1 && isAir[y][x]){
                map[y][x] = 0;
            }
            for(int i=0; i<4; i++){
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if(ny>=N || nx>=M || ny<0 || nx < 0)continue;
                if(map[ny][nx]==0 && !isAir[ny][nx]){
                    isAir[ny][nx] = true;
                    air.add(new int[]{ny,nx});
                }
            }
        }
    }

    private static void findCheese() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1 && !isAir[i][j]){
                    q.add(new int[]{i,j});
                }
            }
        }
    }

    private static void meltingCheese() {
        int count;
        while(!q.isEmpty()){
            count = 0;
            int[] current = q.poll();

            for(int i=0; i<4; i++){
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                if(ny>=N || nx>=M || ny<0 || nx < 0 || !isAir[ny][nx])continue;
                if(map[ny][nx]==0){
                    count++;
                }
            }
            if(count>=2){
                remain--;
                isAir[current[0]][current[1]] = true;
                air.add(new int[]{current[0],current[1]});
            }
        }

    }


}
