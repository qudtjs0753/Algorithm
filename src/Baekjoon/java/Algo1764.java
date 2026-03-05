package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1764 {
    static int N, M,count=0;
    static Map<String, Boolean> name = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            name.put(br.readLine(), true);
        }
        for(int i=0; i<M; i++){
            String input = br.readLine();
            if(name.containsKey(input)){
                result.add(input);
                count++;
            }
        }
        Collections.sort(result);
        for(int i=0; i< result.size(); i++){
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(count);
        System.out.print(sb);
    }
}
