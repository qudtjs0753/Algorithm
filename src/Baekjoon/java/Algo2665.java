package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2665 {
    static class Coordination {
        int x, y;

        public Coordination(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] map,count;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static final int MAX = 2500;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        count = new int[N][N];
        String str;
        for(int i=0; i<N; i++){
            str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i=0; i<N; i++){
            Arrays.fill(count[i], MAX);
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<Coordination> q = new LinkedList<>();
        q.add(new Coordination(0,0));
        if(map[0][0]==1)count[0][0]=0;
        else count[0][0] = 1;

        while(!q.isEmpty()){
            Coordination current = q.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx<0 || ny<0 || nx>N-1 || ny>N-1)continue;

                if(map[ny][nx]==0 && count[ny][nx]>count[current.y][current.x]+1){
                    q.add(new Coordination(ny,nx));
                    count[ny][nx] = count[current.y][current.x] + 1;
                }else if(map[ny][nx]==1 && count[ny][nx]>count[current.y][current.x]){
                    q.add(new Coordination(ny,nx));
                    count[ny][nx] = count[current.y][current.x];
                }
            }
        }

        return count[N-1][N-1];
    }
}
