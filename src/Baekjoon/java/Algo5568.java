package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kbs
 */
public class Algo5568 {
    static int n, k;
    static String[] cards;
    static boolean[] checked;
    static ArrayList<String> picked = new ArrayList<>();
    static HashMap<String, Boolean> ans = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new String[n];
        checked = new boolean[n];
        for(int i=0; i<n; i++){
            cards[i] = br.readLine();
        }
        pickCard(0, "");
        System.out.println(ans.size());
    }
    static void pickCard(int count, String str){
        //뽑고나면 경우의 수 체크.
        if(count==k){
            ans.put(str, true);
            return ;
        }

        for(int i=0; i<cards.length; i++){
            if(!checked[i]){
                checked[i] = true;
                pickCard(count+1, str + cards[i]);
                checked[i] = false;
            }

        }
    }

}
