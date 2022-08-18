package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1166 {
    static long N,L,W,H, min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        min = Math.min(Math.min(L,W), H);
        System.out.println(findA(min));
    }

    private static double findA(double min) {
        double start = 0, end = min;
        int count = 0;
        while(count++<60){
            double mid = (start+end)/2;

            if(N>(long)(L/mid)*(long)(W/mid)*(long)(H/mid)){
                end = mid;
            }else {
                start = mid;
            }
        }

        return end;
    }
}
