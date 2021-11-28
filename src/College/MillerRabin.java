package College;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class MillerRabin {
    static int N;
    static int[] testcase = {2, 7, 61};

    //N-1 = d x 2^s
    public static int isPrime(int a){
        if(N==2 || N==3)return 1;
        if(N%2==0)return 0;
        int expo = N-1;
        int s = divideExponent(expo);
        int d = expo;
        //a^d승 만드는 과정.
        for(int i=0; i<s; i++)
            d /= 2;
        long base= powMod(d,a);
        //case1 : a^d =1(mod n)
        if(case1(base))return 1;

        //case2 : a^(d x 2^r) = -1(mod n)
        return case2(base, s);
    }
    public static boolean case1(long base){
        if(base!=1)
            return false;

        return true;
    }
    public static int case2(long base, int s){
        //0<r<s
        base = base%N;
        for(int i=0; i<s; i++){
            if(base==N-1)
                return 1;
            base = (base*base)%N;
        }
        return 0;
    }

    public static long powMod(int expo, long num){
        num = num%N;
        long ret = 1;
        while(expo>0){
            if (expo%2==1){
                ret = (ret*num)%N;
            }
            num = (num*num)%N;
            expo /= 2;
        }

        return ret;
    }

    public static int divideExponent(int expo){
        int count = 0;
        while(expo%2==0){
            count++;
            expo/=2;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ret=0;
        for(int i=0; i<3; i++){
            if(N<=testcase[i])break;
            if((ret=isPrime(testcase[i]))==1){
                ret = 1;
                break;
            }
        }
        System.out.println(ret);
    }
}
