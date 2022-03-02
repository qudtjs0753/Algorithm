package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1541 {
    static String str;
    static ArrayList<Character> oper = new ArrayList<>();
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch =='-' || ch =='+'){
                oper.add(str.charAt(i));
            }
        }
        StringTokenizer st = new StringTokenizer(str, "+-");
        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(calculateMax(0, nums.get(0)));
    }

    private static int calculateMax(int idx, int num) {
        if(idx>=oper.size()){
            return num;
        }

        int ret = 0;
        if(oper.get(idx)=='-'){
            int sub = nums.get(idx+1);
            idx++;
            while(idx<oper.size() && oper.get(idx)=='+'){
                sub += nums.get(idx+1);
                idx++;
            }
            ret = calculateMax(idx, num-sub);
        }else{
            ret = calculateMax(idx+1, num + nums.get(idx+1));
        }
        return ret;
    }

}
