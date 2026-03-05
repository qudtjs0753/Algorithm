package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo12738 {
    static int N;
    static int[] arr;
    static ArrayList<Integer> listOfLIS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }



        findLIS();

        System.out.println(listOfLIS.size());
    }

    private static void findLIS() {
        int key, left, right;

        // 변수 초기화
        listOfLIS.add(arr[1]);

        for(int i=2; i<=N; i++){
            left = 0;
            right = listOfLIS.size()-1;
            key = arr[i];

            //현재 LIS에서 가장 큰 값과 비교한다.
            if(key>listOfLIS.get(right)){
                listOfLIS.add(key);
            }else{
                //LIS 내에서 어떤 위치에 있는지 parametric search를 통해 확인.
                parametricSearch(left, right, i);
            }
        }

    }

    private static void parametricSearch(int left, int right, int idx) {
        int mid, key = arr[idx];
        while(left < right){
            mid = (left+right) >> 1;
            if(listOfLIS.get(mid)>= key){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        listOfLIS.set(left, key);
    }
}
