package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1212 {
    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = br.readLine();

        for(int i=0; i<N.length(); i++)
            sb.append(getBinary(N.charAt(i)));

        int idx = 0;

        if(!N.equals("0")){
            while(sb.charAt(idx)=='0'){
                idx++;
            }
        }else{
            //0인경우
            System.out.println(N);
            return;
        }

        //000같은 경우
        if(idx==sb.length()){
            System.out.println(0);
        }else{
            System.out.println(sb.substring(idx, sb.length()));
        }
    }

    public static String getBinary(char digit){
        StringBuilder sb = new StringBuilder();
        int number = digit-'0';


        for(int i=0; i<3; i++){
            if(number%2==0){
                sb.append(0);
            }else{
                sb.append(1);
            }
            number/=2;
        }

        return sb.reverse().toString();
    }
}
