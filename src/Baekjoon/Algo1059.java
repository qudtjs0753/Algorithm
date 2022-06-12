package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1059 {
    static int N,L, min = -1, max = 1001;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        arr = new int[L];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        N = Integer.parseInt(br.readLine());

        for (int number : arr) {
            if (number < N) {
                min = number+1;
            } else if (number > N) {
                if(max > number) {
                    max = number-1;
                }
            } else {
                System.out.println(0);
                return;
            }

            if (min != -1 && max != 1001) {
                break;
            }
        }

        if(min==-1){
            min = 1;
        }

        int answer = 0;

        for(int i=min; i<=N; i++){
            for(int j=N; j<=max; j++){
                answer++;
            }
        }
        System.out.println(answer-1);
    }

}
