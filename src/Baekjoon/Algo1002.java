package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1002 {
    static int T, x1, y1, x2, y2,r1,r2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            double d =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if (d == 0 && r1 == r2) {
                sb.append("-1").append("\n");
            } else if (d > Math.abs(r2 - r1) && d < r1 + r2) {
                sb.append("2").append("\n");
            } else if (Math.abs(r2 - r1) == d || r2 + r1 == d) {
                sb.append("1").append("\n");
            } else if (r1 + r2 < d || Math.abs(r2 - r1) > d || d == 0) {
                sb.append("0").append("\n");
            }
        }

        System.out.print(sb);
    }
}
