package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo1065 {
    static int N,count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr;
        for(int i=1; i<=N; i++){
            int num = i;
            arr = new ArrayList<>();
            while(num!=0){
                arr.add(num%10);
                num/=10;
            }
            if(arr.size()<=2) count+=1;
            else{
                boolean isSequence = true;

                for(int idx=2; idx<arr.size(); idx++){
                    if(arr.get(idx-1)-arr.get(idx-2) != arr.get(idx)-arr.get(idx-1)){
                        isSequence = false;
                    }
                }
                if(isSequence==true)count++;
            }
        }
        System.out.println(count);
    }
}
