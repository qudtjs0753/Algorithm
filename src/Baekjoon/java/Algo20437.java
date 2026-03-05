package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo20437 {


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase<=T; testCase++) {
            int result1 = Integer.MAX_VALUE, result2 = -1;
            String input = br.readLine();
            int K = Integer.parseInt(br.readLine());

            //초기화
            ArrayList<Integer>[] conutForAlphabet = new ArrayList[26];
            for(int i=0; i<26; i++) conutForAlphabet[i] = new ArrayList<>();
            for(int i=0; i<input.length(); i++) {
                conutForAlphabet[input.charAt(i)-'a'].add(i);
            }

            //solution
            for(int alphabet=0; alphabet<26; alphabet++) {
                if(conutForAlphabet[alphabet].size()<K) {
                    continue;
                }

                for(int j=0; j<conutForAlphabet[alphabet].size()-K+1; j++) {
                    int firstIdx = conutForAlphabet[alphabet].get(j);
                    int lastIdx = conutForAlphabet[alphabet].get(j+K-1);
                    result1 = Math.min(lastIdx-firstIdx+1, result1);
                    result2 = Math.max(lastIdx-firstIdx+1, result2);
                }
            }

            //answer
            if(result1==Integer.MAX_VALUE || result2==-1) {
                sb.append(-1).append("\n");
            }else {
                sb.append(result1).append(" ").append(result2).append("\n");
            }
        }

        System.out.println(sb);
    }
}
