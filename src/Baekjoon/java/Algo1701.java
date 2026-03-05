package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1701 {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int max = -1;
        for(int i=0; i<str.length(); i++){
            int[] pi = getPartialString(str.substring(i));
            for(int j=0; j<pi.length; j++){
                max = Math.max(max, pi[j]);
            }
        }

        System.out.println(max);
    }


    private static int[] getPartialString(String input) {
        int start = 1, matched = 0;
        int length = input.length();
        int[] pi = new int[length];

        while(start+matched<length){
            if(input.charAt(matched + start) == input.charAt(matched)){
                matched++;
                pi[start + matched-1] = matched;
            }else{
                if(matched==0){
                    start++;
                }else {
                    start += matched - pi[matched-1];
                    matched = pi[matched-1];
                }
            }
        }
        return pi;
    }
}
