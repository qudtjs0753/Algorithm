package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String input = br.readLine();
            if (input.equals("0")) break;
            boolean check = true;
            if(input.length()%2==1){
                if(input.length()==1)sb.append("yes").append("\n");
                else{
                    for(int i=1; i<=input.length()/2; i++){
                        if(input.charAt(input.length()/2 - i) != input.charAt(input.length()/2 + i)){
                            check =false;
                            break;
                        }
                    }
                    if(check)sb.append("yes").append("\n");
                    else sb.append("no").append("\n");
                }
            }else{
                for(int i=0; i<input.length()/2; i++){
                    if(input.charAt(input.length()/2 -1 - i)!=input.charAt(input.length()/2 + i)){
                        check =false;
                        break;
                    }
                }
                if(check)sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}
