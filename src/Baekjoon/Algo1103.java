package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1103 {
    static int N, M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int[][] dp;
    static boolean[][] checked;

    public static int findMaximumCount(int depth, int y, int x){
        // 기저사례1. check했던 곳을 다시 들릴 때
        // 만약 check했던 곳을 들리면 이건 무한번 돌 수 있다는 의미.
        if(depth>dp[y][x]) dp[y][x] = depth;
        int ret = depth;

        if(checked[y][x]) return Integer.MAX_VALUE;

        // 기저사례2. 구멍에 빠지는 경우.
        if(map[y][x] == -1) return ret;


        for(int i=0; i<4; i++){
            //이동시 벗어나지 않는다면.
            int ny = y + dy[i]*map[y][x];
            int nx =  x + dx[i]*map[y][x];
            if(0<=ny && N>ny && 0<=nx && M>nx){

                //dp를 활용해서 만약 이전에 한번 확인했던 경로일 때 더 작거나 같은 경우엔
                //다시 확인할 필요가 없다고 판단해서 확인하지 않는다.
                if(dp[ny][nx]>=depth+1) continue;
                checked[y][x] = true;
                ret = Math.max(findMaximumCount(depth+1, ny, nx), ret);
                checked[y][x] = false;
            }else{
                //이 경우는 이동시 벗어난 경우를 더한 것.
                ret = Math.max(ret, depth+1);
            }
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        checked = new boolean[N][M];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int c=0; c<M; c++){
                char value = line.charAt(c);
                if(value=='H')
                    map[r][c] = -1;
                else
                    map[r][c] = value - '0';
            }
        }

        int result = findMaximumCount(0, 0, 0);

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
}
