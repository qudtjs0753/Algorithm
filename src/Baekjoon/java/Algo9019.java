package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo9019 {
    static int T,A,B,minDepth;
    static String resultStr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            minDepth = 20000;
            resultStr = "";
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs();
        }
        System.out.print(sb);
    }

    private static void bfs() {
        Map<Integer, String> numAndOper = new HashMap<>();
        Queue<Integer> nums = new ArrayDeque<>();
        nums.add(A);
        numAndOper.put(A, "");

        while (!nums.isEmpty()) {
            int current = nums.poll();

            int resultD = operD(current);
            int resultS = operS(current);
            int resultL = operL(current);
            int resultR = operR(current);

            if(!numAndOper.containsKey(resultD)){
                nums.add(resultD);
                numAndOper.put(resultD, numAndOper.get(current).concat("D"));
                if(resultD==B){
                    sb.append(numAndOper.get(resultD)).append("\n");
                    return;
                }
            }
            if(!numAndOper.containsKey(resultS)){
                nums.add(resultS);
                numAndOper.put(resultS, numAndOper.get(current).concat("S"));
                if(resultS==B){
                    sb.append(numAndOper.get(resultS)).append("\n");
                    return;
                }
            }
            if(!numAndOper.containsKey(resultL)){
                nums.add(resultL);
                numAndOper.put(resultL, numAndOper.get(current).concat("L"));
                if(resultL==B){
                    sb.append(numAndOper.get(resultL)).append("\n");
                    return;
                }
            }
            if(!numAndOper.containsKey(resultR)){
                nums.add(resultR);
                numAndOper.put(resultR, numAndOper.get(current).concat("R"));
                if(resultR==B){
                    sb.append(numAndOper.get(resultR)).append("\n");
                    return;
                }
            }
        }
    }

    private  static int operD(int n){
        return (n*2)%10000;
    }
    private static int operS(int n){
        if(n==0)return 9999;
        else return n-1;
    }
    private static int operL(int n){
        int num4 = n%10, num3 = (n/10)%10, num2 =(n/100)%10, num1 = n/1000;

        return ((num2*10 + num3)*10 + num4)*10 + num1;
    }
    private static int operR(int n){
        int num4 = n%10, num3 = (n/10)%10, num2 =(n/100)%10, num1 = n/1000;

        return ((num4*10 + num1)*10 + num2)*10 + num3;
    }
}
