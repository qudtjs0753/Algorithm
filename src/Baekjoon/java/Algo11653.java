package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo11653 {
    static int N;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checked = new boolean[N+1];
        exceptNoPrime();
        for(int i=2; i<=N; i++){
            if(!checked[i])prime.add(i);
        }
        factorization();
        System.out.print(sb);
    }

    private static void factorization() {
        int number = N;

        for(int i=0; i<prime.size(); i++){
            int divisor = prime.get(i);
            while(true){
                if(number==1)return;
                if(number%divisor!=0)break;
                sb.append(divisor + "\n");
                number /= divisor;
            }
        }
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
}
