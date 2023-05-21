package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1157 {

    static StringBuilder sb = new StringBuilder();
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(int i=0; i<input.length(); i++) {
            alphabet[Character.toUpperCase(input.charAt(i))-'A']++;
        }
        int count = 1;
        int maxIdx = 0;
        int max = alphabet[0];
        for(int i=1; i<26; i++) {
            if(alphabet[i]==max) {
                count++;
            }else if(alphabet[i]>max) {
                count=1;
                maxIdx = i;
                max = alphabet[i];
            }
        }

        if(count>1) {
            System.out.println("?");
        }else {
            System.out.println((char)('A' + maxIdx));
        }
    }
}
