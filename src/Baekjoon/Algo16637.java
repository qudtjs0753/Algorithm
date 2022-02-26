package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo16637 {
    static int N;
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> oper = new ArrayList<>();
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = br.readLine();

        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch=='*' || ch=='+' || ch=='-'){
                oper.add(ch);
            }else{
                num.add(ch-'0');
            }
        }

        System.out.println(findMaxValue(0, num.get(0)));
    }

    private static int findMaxValue(int operatorIdx, int value) {
        if(operatorIdx >= oper.size()){
            return value;
        }

        int ret = findMaxValue(operatorIdx+1, calculatePart(value,num.get(operatorIdx+1),oper.get(operatorIdx)));

        if(operatorIdx < oper.size()-1){
            int calc = calculatePart(num.get(operatorIdx+1), num.get(operatorIdx+2), oper.get(operatorIdx+1));
            ret=Math.max(ret, findMaxValue(operatorIdx+2, calculatePart(value, calc, oper.get(operatorIdx))));
        }

        return ret;
    }


    private static int calculatePart(int num1, int num2 ,char operator){
        if(operator=='*'){
            num1 *= num2;
        }
        else if(operator=='-'){
            num1 -= num2;
        }
        else if(operator=='+'){
            num1 += num2;
        }

        return num1;
    }


}
