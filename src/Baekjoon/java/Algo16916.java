package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo16916 {
    static String input, partialString;
    static int[] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        partialString = br.readLine();
        prefix = new int[input.length()];


        kmp();
    }

    private static void kmp() {

        int[] pi = getPartialMatch();
        int begin = 0, matched = 0;

        while(begin <= input.length()-partialString.length()){
            if(matched < partialString.length() && input.charAt(begin + matched) == partialString.charAt(matched)){
                matched++;

                if(matched == partialString.length()){
                    System.out.println(1);
                    return;
                }
            }else{
                if(matched == 0) begin++;
                else{
                    begin += matched - pi[matched-1];
                    matched = pi[matched-1];
                }

            }
        }

        System.out.println(0);
        return;
    }

    private static int[] getPartialMatch(){
        //KMP로 자기 자신 탐색
        //N을 N에서 찾음. begin=0이면 자기 자신을 찾아버림. x
        int begin = 1, matched = 0;
        int[] pi = new int[partialString.length()];

        while(begin + matched < partialString.length()){

            if(partialString.charAt(begin+matched) == partialString.charAt(matched)){
                matched++;
                pi[begin+matched-1] = matched;
            }
            else{
                if(matched == 0)
                    begin++;
                else{
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        return pi;
    }
}
