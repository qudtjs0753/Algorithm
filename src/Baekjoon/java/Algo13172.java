package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo13172 {
    static int M;
    static long result = 0;
    static final int X = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long b = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long inverseElement = fastPower(b);
            result += a*inverseElement%X;
            result %= X;
        }

        System.out.println(result);
    }

    private static long fastPower(long num) {
        int expo = X-2;
        long ret = 1;

        while(expo>=1){
            if(expo%2==1){
                ret = (ret*num)%X;
            }
            num = (num*num)%X;
            expo /= 2;
        }
        return ret;
    }
}
