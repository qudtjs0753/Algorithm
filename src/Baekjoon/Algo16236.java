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
public class Algo16236 {
    static int eatCount = 0, babyShark = 2,N, resultTime = 0;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[][] map, time;
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        time = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    q.add(new int[]{i, j});
                    map[i][j] = 0;
                }
            }
        }

        while(checkAnyEatableFish());


        System.out.println(resultTime);
    }

    private static boolean checkAnyEatableFish() {
        boolean[][] visited = new boolean[N][N];
        int eatable = 0;
        int minDist = Integer.MAX_VALUE;
        int minY=0, minX=0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            visited[current[0]][current[1]] = true;

            for(int i=0; i<4; i++){
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if(ny>=N || nx>=N || ny<0 || nx<0 || map[ny][nx] > babyShark
                        || visited[ny][nx] || time[current[0]][current[1]] +1>minDist)continue;
                q.add(new int[]{ny,nx});
                time[ny][nx] = time[current[0]][current[1]] +1;
                visited[ny][nx] = true;

                //먹을 수 있는 fish인지 체크해서 불가능하면 continue;
                if(map[ny][nx]==0 || map[ny][nx]==babyShark)continue;

                if(time[ny][nx] < minDist){
                    eatable = 1;
                    minDist = time[ny][nx];
                    minY = ny;
                    minX = nx;
                }else if(time[ny][nx] == minDist){
                    eatable++;
                }
            }
        }

        return eatFish(eatable, minDist, minY, minX);
    }

    //순서에 맞게 찾아서 먹는다.
    //만약 한마리도 먹을거 없으면 return false;
    //최단거리상에 한마리 존재하면 걔 찾고 거리 갱신한 뒤 return true;
    //최단거리상에 두마리 이상 존재하면 규칙에따름. 가장 위+가장 왼쪽
    private static boolean eatFish(int eatable,int minDist,int minY, int minX) {
        if(eatable==0)return false;
        q = new ArrayDeque<>();
        resultTime = minDist;

        if(eatable==1){
            q.add(new int[]{minY,minX});
            map[minY][minX] = 0;
        }else if(eatable>1){
            for(int i=0; i<N; i++){
                boolean isChanged = false;
                for(int j=0; j<N; j++){
                    if(map[i][j]!=0 && time[i][j]==minDist && map[i][j] < babyShark){
                        q.add(new int[]{i,j});
                        map[i][j] = 0;
                        isChanged = true;
                        break;
                    }
                }
                if(isChanged)break;
            }
        }
        if(++eatCount==babyShark){
            babyShark++;
            eatCount=0;
        }

        return true;
    }

}
