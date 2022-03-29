package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo16234 {
    static int N,R,L,count=0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] map;
    static boolean[][]visited;

    private static class Coordination {
        int y, x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfsAll();

        System.out.println(count);
    }

    private static void bfsAll() {
        while(true){
            visited = new boolean[N][N];
            boolean isMoved = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        if(bfs(i,j)) isMoved = true;
                    }
                }
            }
            if(isMoved) count++;
            else return;
        }
    }

    private static boolean bfs(int y, int x) {
        Queue<Coordination> q = new ArrayDeque<>();
        List<Coordination> country = new ArrayList<>();

        visited[y][x] = true;
        q.add(new Coordination(y, x));
        country.add(new Coordination(y, x));


        int sum = map[y][x];
        while (!q.isEmpty()) {
            Coordination current = q.poll();

            for(int i=0; i<4; i++){
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];
                if(ny<0 || ny>N-1 || nx<0 || nx>N-1 || visited[ny][nx])continue;
                int sub = Math.abs(map[ny][nx]-map[current.y][current.x]);
                if(sub>=L && sub<=R){
                    visited[ny][nx] = true;
                    q.add(new Coordination(ny,nx));
                    country.add(new Coordination(ny, nx));
                    sum+=map[ny][nx];
                }
            }
        }
        if(country.size()>1){
            for(Coordination ally : country)
                map[ally.y][ally.x] = sum/country.size();
            return true;
        }
        return false;
    }
}
