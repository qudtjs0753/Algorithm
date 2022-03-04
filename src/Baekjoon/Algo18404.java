package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo18404 {
    static class Axis {
        int y, x;

        public Axis(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int N,M,startY,startX;
    static int[][] map,count; //0이면 없는거, 1이면 답, 2이면 나이트가 이동했던 위치.
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
    static ArrayList<Axis> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        count = new int[N+1][N+1];

        for(int i=0; i<=N; i++){
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            list.add(new Axis(y, x));
        }
        bfs();
        for(int i=0; i<list.size(); i++){
            Axis current = list.get(i);
            sb.append(count[current.y][current.x]).append(" ");
        }
        System.out.println(sb);

    }

    private static void bfs() {
        Queue<Axis> q = new ArrayDeque<>();
        q.add(new Axis(startY, startX));
        map[startY][startX] = 2;
        count[startY][startX] = 0;

        while(!q.isEmpty()){
            Axis current = q.poll();

            for(int i=0; i<8; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx>N || ny>N || nx<1 || ny<1)continue;

                if(count[ny][nx]>count[current.y][current.x]+1){
                    count[ny][nx] = count[current.y][current.x] + 1;
                    q.add(new Axis(ny,nx));
                }
            }
        }


    }


}
