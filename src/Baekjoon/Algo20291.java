package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo20291 {
    static int N;
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<String> keys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extend = st.nextToken();
            if(map.containsKey(extend)){
                map.put(extend, map.get(extend)+1);
            }else{
                map.put(extend, 1);
                keys.add(extend);
            }
        }
        Collections.sort(keys);

        for(int i=0; i<keys.size(); i++){
            String key = keys.get(i);
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}
