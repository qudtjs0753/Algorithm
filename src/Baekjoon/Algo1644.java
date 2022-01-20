package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo1644 {
    static int N;
    static boolean[] checked;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checked = new boolean[N+1];
        exceptNoPrime();
        for(int i=2; i<=N; i++){
            if(!checked[i])prime.add(i);
        }
        System.out.println(checkSum());
    }

    static void exceptNoPrime(){
       for(int i=2; i*i<=N; i++){
            if(checked[i])continue;
            int num = i;
            num += i;
            while(num<=N){
                checked[num] = true;
                num +=i;
            }
        }
    }
    static int checkSum(){
        int left = 0, right = 0, sum=0, count=0;
        while(true){
            if(sum>N){
                sum -= prime.get(left++);
            }
            if(sum==N){
                count++;
                sum -= prime.get(left++);
            }
            if(right== prime.size())return count;
            if(sum<N){
                sum += prime.get(right++);
            }
        }
    }
}
