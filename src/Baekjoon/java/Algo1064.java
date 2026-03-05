package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1064 {
    static int max=0,min=Integer.MAX_VALUE;
    static Pair[] arr= new Pair[3];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<3; i++){
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if((arr[0].y-arr[2].y) *(arr[0].x-arr[1].x)==(arr[0].y-arr[1].y)*(arr[0].x-arr[2].x))
            System.out.println(-1.0);
        else{
            double length1 = Math.sqrt(Math.pow(arr[0].y-arr[1].y,2) + Math.pow(arr[0].x-arr[1].x,2));
            double length2 = Math.sqrt(Math.pow(arr[1].y-arr[2].y,2) + Math.pow(arr[1].x-arr[2].x,2));
            double length3 = Math.sqrt(Math.pow(arr[0].y-arr[2].y,2) + Math.pow(arr[0].x-arr[2].x,2));

            double round1 = 2*(length1 + length2);
            double round2 = 2*(length2 + length3);
            double round3 = 2*(length1 + length3);

            double min = Math.min(Math.min(round1, round2), round3);
            double max = Math.max(Math.max(round1, round2), round3);

            System.out.println(max-min);
        }
    }

    static class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
