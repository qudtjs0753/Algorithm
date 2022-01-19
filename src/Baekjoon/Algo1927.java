package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1927 {
    static int N, x, last = 1;
    static long[] arr = new long[100001];
    public static void swap(int idx1, int idx2){
        long temp1 = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp1;
    }
    public static void insert(int num){
        int index = last;
        arr[last] = num;
        while(true){
            if(index==1)break;
            if(arr[index]<arr[index/2])
                swap(index,index/2);
            index/=2;
        }
        last++;
    }
    public static void pop(){
        if(last==1) System.out.println(0);
        else if(last==2){
            System.out.println(arr[1]);
            arr[1] = arr[--last];
        }
        else{
            System.out.println(arr[1]);
            arr[1] = arr[--last];
            int index = 1;
            boolean isChange = true;
            while(isChange){
                isChange = false;
                int left = index *2;
                int right = index*2 +1;
                if(left>last || right>last)break;

                if(arr[left]<=arr[right] && arr[left]<arr[index]){
                    isChange = true;
                    swap(left,index);
                    index = left;
                }else if (arr[left]>arr[right] && arr[right]<arr[index]){
                    isChange = true;
                    swap(right, index);
                    index = right;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)arr[i] = Long.MAX_VALUE;
        for(int i=0; i<N; i++){
           x = Integer.parseInt(br.readLine());
           if(x==0) pop();
           else{
               insert(x);
           }
        }
    }
}
