package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo2143 {
    static int n,m;
    static long T;

    public static void findSubArray(int[] arr,ArrayList<Long> sub,int start, int length){
        long sum = 0;
        while(start<length){
            sum += arr[start++];
            sub.add(sum);
        }
    }

    public static long checkSum(ArrayList<Long> subA, ArrayList<Long> subB){
        int startA = 0;
        int startB =subB.size()-1;
        long ret = 0;
        while(startA<subA.size() && startB>=0){
            //1. A와 B의  포인터가 가리키는 숫자가 겹치는 수를 찾는다.
            long countA = 0;
            long countB = 0;
            long valueA = subA.get(startA);
            long valueB = subB.get(startB);

            //2. A.start랑 B.start랑 더해서 합 비교
            long sum = valueA + valueB;
            if(sum==T){
                while(startA < subA.size() && valueA == subA.get(startA)){
                    //결과적으로 가리키는 값은 다른 값이 되는 경계.
                    startA++;
                    countA++;
                }
                while(startB >=0 && valueB == subB.get(startB)){
                    //결과적으로 가리키는 값은 다른 값이 되는 경계.
                    startB--;
                    countB++;
                }
               ret += countA * countB;
            }else if(sum>T){
                startB--;
            }else{
                startA++;
            }
            //3. 반복
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        ArrayList<Long> subA= new ArrayList<>();
        ArrayList<Long> subB = new ArrayList<>();

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            A[i] = value;
        }
        m = Integer.parseInt(br.readLine());
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int value = Integer.parseInt(st.nextToken());
            B[i] = value;
        }
        for(int i=0; i<n; i++){
            findSubArray(A,subA,i, n);
        }
        for(int i=0; i<m; i++){
            findSubArray(B,subB,i, m);
        }
        Collections.sort(subA);
        Collections.sort(subB);
        System.out.println(checkSum(subA,subB));
    }
}
