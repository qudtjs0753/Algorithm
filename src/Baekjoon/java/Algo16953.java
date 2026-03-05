package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo16953 {
    static long a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());


        int result = Math.min(operate(a,1, 1),operate(a,2, 1));
        if(result==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    private static int operate(long num, int operateType, int count) {

        if(num>b)return Integer.MAX_VALUE;
        else if(num==b)return count;
        if(operateType==1)
            return Math.min(operate(num*2, 1,count+1),
                    operate(num*2, 2, count+1));
        else
            return Math.min(operate(num*10 + 1, 1,count+1),
                    operate(num*10 + 1, 2, count+1));
    }

}
