package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo16172 {
    static String partialString;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputWithNum = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<inputWithNum.length(); i++){
            if(inputWithNum.charAt(i)>='0' && inputWithNum.charAt(i)<='9')continue;
            sb.append(inputWithNum.charAt(i));
        }

        partialString = br.readLine();

        kmp(sb.toString());
    }

    private static void kmp(String inputWithoutNum) {
        int begin = 0, matched = 0;
        int inputLength = inputWithoutNum.length();
        int partialStringLength = partialString.length();
        int[] pi = getPartialString();

        while(begin <= inputLength - partialStringLength){
            if(matched<partialStringLength && inputWithoutNum.charAt(begin + matched)==partialString.charAt(matched)){
                matched++;
                if(matched==partialStringLength){
                    System.out.println(1);
                    return;
                }
            }else{
                if(matched==0){
                    begin++;
                }else{
                    begin += matched - pi[matched-1];
                    matched = pi[matched-1];
                }
            }

        }
        System.out.println(0);
    }

    private static int[] getPartialString() {
        int begin = 1, matched = 0;
        int partialStringLength = partialString.length();
        int[] pi = new int[partialStringLength];

        while(matched + begin < partialStringLength){
            if(partialString.charAt(begin + matched)==partialString.charAt(matched)){
                matched++;
                pi[begin+matched-1] = matched;
            }else{
                if(matched==0){
                    begin++;
                }else{
                    begin += matched - pi[matched-1];
                    matched = pi[matched-1];
                }
            }
        }
        return pi;
    }
}
