package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1085 {
    static int x,y,w,h, min = 10000;
    public static void main(String[] args) throws IOException {
        //x = 0 , y= 0, x=w, y=h 4개 비교
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        min = Math.min(Math.abs(x),min);
        min = Math.min(Math.abs(y),min);
        min = Math.min(Math.abs(x-w),min);
        min = Math.min(Math.abs(y-h),min);

        System.out.println(min);
    }
}
