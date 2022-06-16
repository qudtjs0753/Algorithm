package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: kbs
 */
public class Algo11508 {
    static int N, result = 0;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        arr.sort(Collections.reverseOrder());

        int count = 0;
        for(int i=0; i<N; i++){
            count++;
            result += arr.get(i);
            if(count==3){
                result -= arr.get(i);
                count = 0;
            }
        }

        System.out.println(result);
    }
}
