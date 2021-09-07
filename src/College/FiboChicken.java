package College;

import java.util.ArrayList;
import java.util.Scanner;

public class FiboChicken {
    static boolean[] arr = new boolean[50];
    static int[] cache = new int[50];

    public static int fibonacci(int n){
        if(n==0)return 0;
        else if(n==1)return 1;
        else{
            if(cache[n]!=0)return cache[n];
            return cache[n] = fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static int zeckendorf(ArrayList<Integer> fibo , int n, int pos, int sum){
        if(sum>n)return 0;
        int ret=0;
        if(sum==n){
            for(int i=0; i<50; i++){
                if(arr[i])ret += fibo.get(i-1);
            }
            return ret;
        }
        for(int i=pos-2; i>1; i--){
            arr[i]=true;
            ret += zeckendorf(fibo, n, i, sum+fibo.get(i));
            arr[i]=false;
            if(ret>0)break;
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result=0;
        int num=0;
        ArrayList<Integer> fibo = new ArrayList<Integer>();
        for(int i=0; (num=fibonacci(i))<n; i++){
            fibo.add(num);
        }
        for(int i=fibo.size()-1; i>1;i--){
            arr[i]=true;
            result+=zeckendorf(fibo, n, i, fibo.get(i));
            arr[i]=false;
            if(result>0) break;
        }
        System.out.println(result);
    }

}
