package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: kbs
 */
public class Algo2504 {
    static String input;
    static int leng;
    static String[] open = {"(", "["};
    static String[] close = {")", "]"};
    static boolean correct = true;
    static Stack<String> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        leng = input.length();
        calculate(0);
        int result = 0;
        while(!stack.isEmpty()){
            String val = stack.pop();
            if(val==open[0] || val==open[1] || val==close[0] || val==close[1]){
                correct = false;
                break;
            }else{
                result += Integer.parseInt(val);
            }
        }
        if(correct) System.out.println(result);
        else System.out.println(0);
    }
    public static void calculate(int index) {


        if(index>=leng) return;
        String c = Character.toString(input.charAt(index));

        if((c.equals(close[0])||c.equals(close[1]))&& stack.isEmpty()){
            correct = false;
            return;
        }
        Stack<Integer> tmp = new Stack<>();

        if(c.equals(open[0])){
            stack.push(close[0]);
        }
        else if(c.equals(open[1])){
            stack.push(close[1]);
        }
        else if(c.equals(close[0])) {
            String val = stack.pop();
            while(!val.equals(close[0])){
                if(stack.isEmpty() || val.equals(close[1])){
                    correct = false;
                    return;
                }
                tmp.push( Integer.parseInt(val));
                val = stack.pop();
            }
            if(tmp.isEmpty())stack.push("2");
            else{
                int sum = sum(tmp);
                stack.push(Integer.toString(sum*2));
            }
        }
        else if(c.equals(close[1])){
            String val = stack.pop();
            while(!val.equals(close[1])){
                if(stack.isEmpty() || val.equals(close[0])){
                    correct = false;
                    return;
                }
                tmp.push(Integer.parseInt(val));
                val = stack.pop();
            }
            if(tmp.isEmpty())stack.push("3");
            else{
                int sum = sum(tmp);
                stack.push(Integer.toString(sum*3));
            }
        }else {
            String val = stack.pop();
            while(val==open[0] || val==open[1] || val==close[0] || val==close[1]){
                tmp.push(Integer.parseInt(val));
            }
            stack.push(Integer.toString(sum(tmp)));
        }
        calculate(index+1);
    }

    private static int sum(Stack<Integer> tmp) {
        int result=0;
        while(!tmp.isEmpty()){
            result += tmp.pop();
        }
        return result;
    }
}
