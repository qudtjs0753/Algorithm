package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo9375 {
    static int T,N;
    static Map<String, Integer> clothes;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            N = Integer.parseInt(br.readLine());
            clothes = new HashMap<>();
            list = new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                if(!clothes.containsKey(kind)){
                    list.add(kind);
                }
                clothes.put(kind, clothes.getOrDefault(kind, 0) + 1);
            }
            int result = 1;
            for(String clothesKind : list){
                result *= clothes.get(clothesKind)+1;
            }
            sb.append(result -1).append("\n");
        }

        System.out.print(sb);
    }
}
