package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Author: kbs
 */
public class Algo15721 {
    static int T, A,findPhrase, count=0;
    static int bdCount = 2;
    static int[] bd = {0,1,0,1};
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        findPhrase = Integer.parseInt(br.readLine());

        for(int i=0; i<A; i++)q.add(i);

        while(true){
            int current;
            for(int i=0; i<4; i++){
                current = q.poll();
                if(findPhrase==bd[i])count++;
                if(count==T){
                    System.out.println(current);
                    return;
                }
                q.add(current);
            }
            for(int i=0; i<bdCount; i++){
                current = q.poll();
                if(findPhrase==0){
                    count++;
                }
                if(count==T){
                    System.out.println(current);
                    return;
                }
                q.add(current);
            }
            for(int i=0; i<bdCount; i++){
                current = q.poll();
                if(findPhrase==1){
                    count++;
                }
                if(count==T){
                    System.out.println(current);
                    return;
                }
                q.add(current);
            }
            bdCount++;
        }
    }
}
