package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo21608 {
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] student;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[21][21];
        student = new boolean[N*N + 1][N*N + 1];

        for(int i=0; i<N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            for(int j=0; j<4; j++){
                student[current][Integer.parseInt(st.nextToken())] = true;
            }

            setPosition(current);
        }

        System.out.println(getSatisfaction());

    }

    private static int getSatisfaction() {
        int ret = 0,count, point;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                count = 0;
                point = 0;
                for(int k=0; k<4; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(ny>N || ny<1 || nx>N || nx<1)continue;

                    if(student[map[i][j]][map[ny][nx]]){
                        count++;
                    }
                }
                if(count>=1)point+=1;
                for(int k=0; k<count-1; k++){
                    point *= 10;
                }

                ret += point;
            }
        }

        return ret;
    }

    private static void setPosition(int currentStudent) {
        int emptyMax = 0, favoriteMax = 0;
        int toSetPosX = -1, toSetPosY = -1;
        boolean isEmpty = false;

        //맨 윗줄 맨 왼쪽 find.
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]==0){
                    toSetPosY = i;
                    toSetPosX = j;
                    isEmpty = true;
                    break;
                }
            }
            if(isEmpty)break;
        }

        //1,2번조건 find.
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]!=0)continue;
                int emptyCount = 0, favoriteCount = 0;

                for(int k=0; k<4; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(ny>N || ny<1 || nx>N || nx<1)continue;
                    if(map[ny][nx]==0)emptyCount++;
                    else if(student[currentStudent][map[ny][nx]]){
                        favoriteCount++;
                    }
                }

                if(favoriteCount>favoriteMax){
                    favoriteMax = favoriteCount;
                    emptyMax = emptyCount;
                    toSetPosY = i;
                    toSetPosX = j;
                }else if(favoriteMax==favoriteCount){
                    if(emptyCount>emptyMax){
                        emptyMax = emptyCount;
                        toSetPosY = i;
                        toSetPosX = j;
                    }
                }
            }
        }

        map[toSetPosY][toSetPosX] = currentStudent;
    }
}
