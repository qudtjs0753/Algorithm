package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1004 {
    static int N,T;
    static int x1,y1,x2,y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if(checkPos(cx,cy,r))
                    count++;

            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean checkPos(int cx, int cy, int r) {
        double distOfStartingPoint = Math.sqrt(Math.pow(cy-y1,2) + Math.pow(cx-x1,2));
        double distOfEndPoint = Math.sqrt(Math.pow(cy-y2,2) + Math.pow(cx-x2,2));

        if((r>distOfEndPoint&&r>distOfStartingPoint) || (r<distOfEndPoint && r<distOfStartingPoint))return false;
        return true;
    }
}
