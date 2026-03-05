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
public class Algo7569 {
    static int H,N,M, allTomato=0;
    static int map[][][];
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static class Coordination {
        int z, y, x;

        public Coordination(int z, int y, int x) {
            this.z = z;
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
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==1)q.add(new Coordination(i,j,k));
                    if(map[i][j][k]==-1)continue;
                    allTomato++;
                }
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
            for(int i=0; i<6; i++){
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                int nz = tomato.z + dz[i];
                if(nx >=0 && nx <M && ny >=0 && ny <N &&
                        nz >=0 && nz <H
                ){
                    if(map[nz][ny][nx]==0){
                        map[nz][ny][nx] = map[tomato.z][tomato.y][tomato.x]+1;
                        q.add(new Coordination(nz,ny,nx));
                    }
                }
            }
            max = Math.max(max,map[tomato.z][tomato.y][tomato.x]);
        }

        if(count==allTomato)return max-1;
        else return -1;
    }

}
