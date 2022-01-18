package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2096 {
    static int[] dpMax, dpMin;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dpMax = new int[3];
        dpMin = new int[3];
        int[] input = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[j]  = Integer.parseInt(st.nextToken());
            }
            findVal(input);
        }

        int maxVal, minVal;
        maxVal = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        minVal = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
        System.out.println(maxVal + " " + minVal);
    }

    public static void findVal(int[] input) {
        //dpMax
        int tempMax0 = dpMax[0], tempMax1 = dpMax[1];
        int tempMin0 = dpMin[0], tempMin1 = dpMin[1];
        dpMax[0] = Math.max(dpMax[0], dpMax[1]) + input[0];
        dpMax[1] = Math.max(dpMax[2], Math.max(tempMax0, dpMax[1])) + input[1];
        dpMax[2] = Math.max(tempMax1, dpMax[2]) + input[2];
        //dpMin
        dpMin[0] = Math.min(dpMin[0], dpMin[1]) + input[0];
        dpMin[1] = Math.min(dpMin[2], Math.min(tempMin0, dpMin[1])) + input[1];
        dpMin[2] = Math.min(tempMin1, dpMin[2]) + input[2];

    }

}
