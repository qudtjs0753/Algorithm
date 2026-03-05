package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo12015 {
    static int N;
    static int[] arr,index;
    static ArrayList<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        index = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        lisWithBinarySearch();

        System.out.println(lis.size());
    }

    private static void lisWithBinarySearch(){
        int left, right,num,mid;
        lis.add(arr[1]);
        index[1] = 1;
        for(int i=2; i<=N; i++){
            left = 0;
            right = lis.size()-1;
            num = arr[i];

            if(num>lis.get(right)){
                lis.add(num);
                index[i] = lis.size()-1;
            }else{
                while(left<right){
                    mid = (left+right)/2;
                    if(lis.get(mid) >= num){
                        right= mid;
                    }else{
                        left = mid+1;
                    }
                }
                lis.set(right, num);
                index[lis.size()-1] = right;
            }
        }
    }
}
