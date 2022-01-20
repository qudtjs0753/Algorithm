package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1837 {
    static int K;
    static String P;
    static boolean[] checked;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        checked = new boolean[K];
        exceptNoPrime();
        for(int i = 2; i< K; i++){
            if(!checked[i])prime.add(i);
        }
        int result = divideByPrime();
        if(result==0) System.out.println("GOOD");
        else System.out.println("BAD " + result);
    }

    static int divideByPrime() {
        int ret = 0;
        for(int i=0; i<prime.size(); i++){
            int divisor = prime.get(i);
            if(divideBigNum(divisor)) return divisor;
        }
        return 0;
    }

    static boolean divideBigNum(int prime){
        int ret = 0;
        for(int i=0; i<P.length(); i++){
            ret *= 10;
            ret += P.charAt(i) - '0';
            ret %= prime;
        }
        return ret == 0;
    }

    static void exceptNoPrime(){
        for(int i = 2; i*i<= K; i++){
            if(checked[i])continue;
            int num = i;
            num += i;
            while(num< K){
                checked[num] = true;
                num +=i;
            }
        }
    }
}
