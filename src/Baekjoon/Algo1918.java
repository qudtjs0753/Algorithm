package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: kbs
 */
public class Algo1918 {
    static Deque<Character> operator = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        getPostOrder();
        System.out.println(sb);
    }

    private static void getPostOrder() {
        for(int i=0; i<input.length(); i++){
            Character currentChar = input.charAt(i);
            if(currentChar=='(')operator.push(currentChar);
            else if(currentChar==')'){
                while(!operator.isEmpty() && operator.peek() != '('){
                    sb.append(operator.pop());
                }
                if(!operator.isEmpty())operator.pop();
            }else if(currentChar == '+' || currentChar =='-' || currentChar=='*' || currentChar =='/') {
                while(!operator.isEmpty() && precedence(operator.peek()) >=precedence(currentChar)){
                    sb.append(operator.pop());
                }
                operator.push(currentChar);
            }else {
                sb.append(currentChar);
            }
        }
        while(!operator.isEmpty()){
            sb.append(operator.pop());
        }
    }

    public static int precedence(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
}
