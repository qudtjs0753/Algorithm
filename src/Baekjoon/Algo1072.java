package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1072 {
    static int x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        if(x==y) System.out.println(-1);
        else {
            int result = -1;
            int left = 0;
            int right = (int) 1e9;
            long z = getPercent(x, y);
            while(left <= right){
                int mid = (left + right)/2;
                if (getPercent(x + mid, y + mid )!=z){
                    right = mid-1;
                    result = mid;
                }else {
                    left = mid+1;
                }
            }
            System.out.println(result);
        }
    }

    static long getPercent(int x, int y){
        return ((long) y*100/x);
    }
}
