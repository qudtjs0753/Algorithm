package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo3356 {
    static int L;
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        S = br.readLine();

        System.out.println( getPartialLength());
    }

    private static int getPartialLength() {
        int begin = 1, matched = 0;
        int[] pi = new int[L];
        while(begin + matched < L){
            if(S.charAt(begin+matched) == S.charAt(matched)){
                matched++;
                pi[matched+begin-1] = matched;
            }else {
                if(matched==0){
                    begin++;
                }else{
                    begin += matched-pi[matched-1];
                    matched = pi[matched-1];
                }
            }
        }

        return L - pi[L-1];
    }
}
