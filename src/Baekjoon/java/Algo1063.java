package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1063 {
    static int N,kingX,kingY, stoneX,stoneY;
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dx = {1,-1, 0, 0, 1, -1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String pos = st.nextToken();
        kingX = pos.charAt(0)-'A'+ 1;
        kingY = pos.charAt(1)-'0';

        pos = st.nextToken();
        stoneX = pos.charAt(0)-'A'+1;
        stoneY = pos.charAt(1)-'0';

        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String input = br.readLine();

            checkInput(input);
        }

        char lastKingX =(char)((int)'A' + kingX-1);
        char lastStoneX =(char)((int)'A' + stoneX-1);
        System.out.print(lastKingX);
        System.out.println(kingY);
        System.out.print(lastStoneX);
        System.out.println(stoneY);

    }

    private static void checkInput(String input) {

        switch (input){
            case "R": move(0);
                break;
            case "L": move(1);
                break;
            case "B": move(2);
                break;
            case "T": move(3);
                break;
            case "RT": move(4);
                break;
            case "LT": move(5);
                break;
            case "RB": move(6);
                break;
            case "LB": move(7);
                break;
        }

    }

    private static void move(int i) {
        int nKingX = kingX+dx[i];
        int nKingY = kingY+dy[i];
        int nStoneX = stoneX+dx[i];
        int nStoneY = stoneY+dy[i];

        if(nKingX>=9 || nKingX<=0 || nKingY>=9 || nKingY<=0)return;

        if(nKingX==stoneX && nKingY==stoneY){
            if(nStoneX>= 9 || nStoneX<=0 || nStoneY>=9 || nStoneY<=0)return;
            stoneX = nStoneX; stoneY = nStoneY;
            kingX = nKingX; kingY = nKingY;
        }else {
            kingX = nKingX; kingY = nKingY;
        }
    }
}
