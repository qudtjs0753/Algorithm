package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1786 {
    static int count=0;
    static String T, P;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        P = br.readLine();

        kmp();

        System.out.println(count);
        System.out.println(sb);
    }

    private static void kmp() {
        int tLength = T.length(), pLength = P.length();
        int[] pi = getPartialMatch();

        int matched = 0;

        for(int i=0; i<tLength; i++){
            while(matched > 0 && T.charAt(i) != P.charAt(matched))
                matched = pi[matched-1];
            if(T.charAt(i)==P.charAt(matched)){
                matched++;
                if(matched==pLength){
                    count++;
                    sb.append(i-pLength+2).append(" ");
                    matched = pi[matched-1];
                }
            }
        }
    }

    private static int[] getPartialMatch() {
        int pLength = P.length();
        int[] pi = new int[pLength];
        int matched = 0;

        for(int i=1; i<pLength; i++){
            while (matched > 0 && P.charAt(i) != P.charAt(matched)) {
                matched = pi[matched-1];
            }
            if(P.charAt(i)==P.charAt(matched)){
                pi[i] = ++matched;
            }
        }
        return pi;
    }
}
