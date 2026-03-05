package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1620 {
    static int N,M;
    static Map<String, Integer> name = new HashMap<>();
    static String[] idxOfName;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        idxOfName = new String[N+1];

        for(int i=1; i<=N; i++){
            String input = br.readLine();
            idxOfName[i] = input;
            name.put(input, i);
        }

        for(int i=1; i<=M; i++){
            String input = br.readLine();

            if(Character.isDigit(input.charAt(0))){
                sb.append(idxOfName[Integer.parseInt(input)]).append("\n");
            }else{
                sb.append(name.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
