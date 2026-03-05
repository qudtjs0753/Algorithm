package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo14400 {
    static int N;
    static long sum=0;
    static ArrayList<Integer> allY = new ArrayList<>();
    static ArrayList<Integer> allX = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            allX.add(nx);
            allY.add(ny);

        }
        Collections.sort(allX);
        Collections.sort(allY);
        int centerX = allX.get(N/2);
        int centerY = allY.get(N/2);

        for(int i=0; i<N; i++){
            sum += Math.abs(centerX-allX.get(i)) + Math.abs(centerY-allY.get(i));
        }

        System.out.println(sum);
    }
}
