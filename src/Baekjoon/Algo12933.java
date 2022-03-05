package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: kbs
 */
public class Algo12933 {
    static Queue<Integer> order = new LinkedList<>();
    static boolean[] visit;
    static String quack = "quack";
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        visit = new boolean[input.length()];

        int maxSize = 0;

        if(input.length()%5!=0){
            System.out.println(-1);
            return;
        }

        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch==quack.charAt(0)){
                visit[i]=true;
                order.add(1);
                maxSize = Math.max(maxSize, order.size());
            }else{
                for(int j=0; j<order.size(); j++){
                    int idx = order.poll();

                    if(quack.charAt(idx)==ch){
                        visit[i]=true;
                        if(idx+1>=5) break;

                        order.add(idx+1);
                        break;
                    }
                    order.add(idx);
                }
            }
        }
        for(int i=0; i<input.length(); i++){
            if(!visit[i]){
                System.out.println(-1);
                return;
            }
        }

        if(!order.isEmpty()){
            System.out.println(-1);
            return;
        }

        System.out.println(maxSize);
    }
}
