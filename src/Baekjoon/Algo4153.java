package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo4153 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       while(true){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());
           if(a==0 && a==b && b==c)break;

           if(a*a + b*b == c*c || b*b + c*c == a*a || c*c + a*a==b*b){
               sb.append("right\n");
           }else{
               sb.append("wrong\n");
           }
       }
        System.out.println(sb);
    }
}
