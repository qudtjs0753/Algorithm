package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo14002 {
    static int N;
    static int[] arr, indexOrder;
    static ArrayList<Integer> listOfLIS = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        indexOrder = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken()); 

        
        findLIS();

        getLIS();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void getLIS() {
        Stack<Integer> st = new Stack<>();
        int length= listOfLIS.size();

        for(int i=N; i>=1; i--){
            if(indexOrder[i] == length){
                st.push(arr[i]);
                length--;
            }
        }

        while(!st.isEmpty())
            sb.append(st.pop()).append(" ");
    }

    private static void findLIS() {
        int left, right, key;
        listOfLIS.add(arr[1]);
        indexOrder[1] = 1;
        for(int i=2; i<=N; i++){
            left = 0;
            right = listOfLIS.size()-1;
            key = arr[i];
            if(listOfLIS.get(right)<key){
                listOfLIS.add(key);
                indexOrder[i] = listOfLIS.size();
            }else{
                parametricSearch(left,right,i);
            }
        }
        sb.append(listOfLIS.size()).append("\n");
    }

    private static void parametricSearch(int left, int right, int idx) {
        int mid, key = arr[idx];

        while(left<right){
            mid = (left+right) >> 1;
            if(listOfLIS.get(mid)>=key){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        listOfLIS.set(left, key);
        indexOrder[idx] = left+1;
    }
}
