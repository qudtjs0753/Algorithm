package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1439 {
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        char current = input.charAt(0);
        int count = 0;
        boolean swapped = false;

        for(int i=1; i<input.length(); i++){
            if(current!=input.charAt(i)){
                current = input.charAt(i);
                if(!swapped)count++;
                swapped = !swapped;
            }
        }

        System.out.println(count);
    }
}
