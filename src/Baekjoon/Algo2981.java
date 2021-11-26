package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: kbs
 */
public class Algo2981 {
    static int N, minimum=Integer.MAX_VALUE;
    static int[]paper;
    static List<Integer> M = new ArrayList<>();

    public static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b, a%b);
    }
    public static void findNum(){
        int gcd1 = paper[1]-paper[0];
        for(int i=1; i<N-1; i++){
            gcd1 = gcd(paper[i+1]-paper[i],gcd1);
        }
        for(int i=2; i<=gcd1/2; i++){
            if(gcd1%i==0)M.add(i);
        }
        M.add(gcd1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        paper = new int[N];
        for (int i = 0; i < N; i++){
            paper[i] = Integer.parseInt(br.readLine());
            if(minimum>paper[i]) minimum = paper[i];
        }
        Arrays.sort(paper);
        findNum();
        for(int i=0; i<M.size(); i++){
            bw.write(String.valueOf(M.get(i)) + " ");
        }
        bw.flush();
        bw.close();
    }
}
