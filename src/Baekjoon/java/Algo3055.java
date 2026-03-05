package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo3055 {
    static int R, C;
    static char[][] map;
    //고슴도치 이동하는 곳에 숫자로 한턴만에 갈 수있는 곳, 두턴에 갈 수있는곳 cost에 기록
    static int[][] cost;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    static Queue<Position> queue = new LinkedList<>();

    static class Position {
        int row, col;
        char type;

        Position(int row, int col, char type){
            super();
            this.row = row;
            this.col = col;
            this.type = type;
        }
    }
    public static boolean bfs(){

        //물이 이동하는것은 지도에 확장시켜준다. 물은 목적지가 없다.
        //갈 수 있는곳만 순회.
        //물 이동 고슴도치 이동 순서대로하면 다음번 물의 위치를 고려할 필요가 없다.
        while(!queue.isEmpty()){
            Position start = queue.poll();

            if(start.type=='D'){
                System.out.println(cost[start.row][start.col]);
                return true;
            }
            for(int i=0; i<nx.length; i++) {
                int dy = start.row + ny[i];
                int dx = start.col + nx[i];

                if((dy>=0 && dy< R) && (dx>=0 && dx < C)){
                    isValidPosForHedgeDog(dy,dx,start);
                    isValidPosForWater(dy,dx,start);
                }
            }
        }
        return false;
    }

    public static void isValidPosForHedgeDog(int dy, int dx, Position start){
        if (start.type == 'S' || start.type == '.') {
            if ((map[dy][dx] =='.' || map[dy][dx] == 'D') && cost[dy][dx] == 0) {
                queue.add(new Position(dy, dx, map[dy][dx]));
                cost[dy][dx] = cost[start.row][start.col] + 1;
            }
        }
    }
    public static void isValidPosForWater(int dy, int dx, Position start){
        if (start.type == '*') {
            if (map[dy][dx] =='.' || map[dy][dx] == 'S') {
                queue.add(new Position(dy, dx, '*'));
                map[dy][dx] = '*';
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Position start = null;

        map = new char[R][C];
        cost = new int[R][C];

        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] =  input.charAt(j);
                if( map[i][j] =='*'){;
                    queue.add(new Position(i,j,'*'));
                }
                else if(map[i][j]=='S')
                    start = new Position(i,j,'S');
            }
        }

        queue.add(start);
        boolean result = bfs();
        if(!result)
            System.out.println("KAKTUS");
    }
}
