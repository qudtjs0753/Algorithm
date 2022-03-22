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
public class Algo7576 {
    static int N,M, allTomato=0;
    static int map[][];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Coordination {
        int y, x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static Queue<Coordination> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)q.add(new Coordination(i,j));
                if(map[i][j]==-1)continue;
                allTomato++;
            }
        }
        if(q.size()==allTomato){
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int count = 0;
        int max = 0;
        Coordination tomato;
        while(!q.isEmpty()){
            count++;
            tomato = q.poll();
            for(int i=0; i<4; i++){
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
;
                if(nx >=0 && nx <M && ny >=0 && ny <N){
                    if(map[ny][nx]==0){
                        map[ny][nx] = map[tomato.y][tomato.x]+1;
                        q.add(new Coordination(ny,nx));
                    }
                }
            }
            max = Math.max(max,map[tomato.y][tomato.x]);
        }

        if(count==allTomato)return max-1;
        else return -1;
    }

}
