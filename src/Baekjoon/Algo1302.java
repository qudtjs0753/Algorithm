package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1302 {
    static Map<String, Integer> books = new HashMap<>();
    static ArrayList<String> result = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int max = 0;
        for(int i=0; i<N; i++){
            String input = br.readLine();
            books.put(input, books.getOrDefault(input, 0)+1);
            if(books.get(input)>max){
                max = books.get(input);
            }
        }

        for(String str : books.keySet()){
            if(books.get(str) == max){
                result.add(str);
            }
        }
        Collections.sort(result);

        System.out.println(result.get(0));
    }
}
