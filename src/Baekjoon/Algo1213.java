package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Author: kbs
 */
public class Algo1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        int[] count = new int[26];
        int oddCount = 0, oddPos=-1;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<input.length(); i++){
            Character ch = input.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(Character key : map.keySet()){
            Integer value = map.get(key);
            if(value%2==1){
                oddCount++;
                oddPos = key - 'A';
            }
            count[key-'A'] = value;
        }

        if(oddCount>=2){
            System.out.println("I'm Sorry Hansoo");
            return;
        }else{
            for(int i=0; i<26; i++){
                for( int j=0; j<count[i]/2; j++){
                    sb.append((char)('A' + i));
                }
            }
        }
        System.out.print(sb);
        if(oddPos!=-1) {
            System.out.print((char)('A' + oddPos));
        }
        System.out.println(sb.reverse());
    }
}
