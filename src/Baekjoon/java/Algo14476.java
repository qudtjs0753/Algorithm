package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo14476 {
    static int N, max=-1, K;
    static int[] numbers, leftAcc, rightAcc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        leftAcc = new int[N];
        rightAcc = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        leftAcc[0] = numbers[0];
        rightAcc[N-1] = numbers[N-1];

        for(int i=1; i<N-1; i++){
            leftAcc[i] = gcd(leftAcc[i-1],numbers[i]);
            rightAcc[N-1-i] = gcd(numbers[N-1-i],rightAcc[N-i]);
        }

        for(int i=0; i<N;i++){
            findAllGcd(i);
        }
        if(max==-1){
            System.out.println(max);
        }
        else System.out.println(max + " " + K);
    }

    private static void findAllGcd(int idx) {
        int tmp;
        if(idx==0){
            tmp = rightAcc[1];
        }
        else if(idx==N-1){
            tmp = leftAcc[N-2];
        }
        else{
            tmp = gcd(leftAcc[idx-1], rightAcc[idx+1]);
        }
        if (numbers[idx]%tmp!=0 && max<tmp){
            max = Math.max(max,tmp);
            K = numbers[idx];
        }
    }

    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
