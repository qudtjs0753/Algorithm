package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo4949 {
    static String input="";
    static String start = "([";
    static String end = ")]";

    public static int findFirst(char ch){
        if(ch == start.charAt(0))
            return 0;
        else if(ch == start.charAt(1))
            return 1;
        return -1;
    }
    public static int findEnd(char ch){
        if(ch == end.charAt(0))
            return 0;
        else if(ch == end.charAt(1))
            return 1;
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!input.equals(".")){
            ArrayList<Character> stack = new ArrayList<>();
            input = br.readLine();
            if(input.equals("."))return;
            for(int i=0; i<input.length(); i++){
                char ch = input.charAt(i);

                //끝에 도달 + stack 다 비웠을 때
                if(ch=='.' && stack.isEmpty()){
                    System.out.println("yes");
                    break;
                }
                //끝에 도달 + stack 다 못비웠을 때
                if(ch=='.' && !stack.isEmpty()){
                    System.out.println("no");
                    break;
                }
                //bracket시작점인경우
                if(findFirst(ch)!=-1){
                    stack.add(ch);
                }

                //bracket endpoint인경우
                if(findEnd(ch)!=-1){
                    //짝 안맞으면 no 때리고 끝
                    if(stack.isEmpty()||findFirst(stack.get(stack.size()-1))!=findEnd(ch)){
                        System.out.println("no");
                        break;
                    }
                    //짝 맞으면 스택 top 제거
                    else{
                        stack.remove(stack.size()-1);
                    }
                }
            }
        }
    }
}
