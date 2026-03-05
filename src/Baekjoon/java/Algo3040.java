package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Algo3040 {
    public static void findSmall(int[] arr,int index,int sum){
        int sumEx = sum;
        //찾는게 없을경우 종료.
        if(index==8) return;
        for(int i=index+1; i<9; i++){
            sumEx -= (arr[index]+ arr[i]);
            //찾았을 때. print하고 종료
            if(sumEx==100){
                for(int j=0; j<9; j++){
                    if(j!=index && j!=i){
                        System.out.println(arr[j]);
                    }
                }
                return;
            }
            sumEx = sum;
        }
        //다음 인덱스부터 찾는다.
        findSmall(arr, index+1, sum);
    }

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        try{
            for(int i=0; i<9; i++){
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
            }
            findSmall(arr,0,sum);
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
