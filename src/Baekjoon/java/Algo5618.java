package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo5618 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n");

        arr = new int[n];
        Arrays.sort(arr);

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int divisor = 2;

        while(divisor<=arr[0]){
            boolean canDivide = true;
            for(int i=0; i<n; i++){
                if(arr[i]%divisor!=0){
                    canDivide =false;
                    break;
                }
            }
            if(canDivide){
                sb.append(divisor).append("\n");
            }
            divisor++;
        }

        System.out.println(sb);
    }
}
