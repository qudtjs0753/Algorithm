package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo14003 {
    static int N;
    static int[] arr, indexOrder;
    static ArrayList<Integer> listLIS = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        indexOrder = new int[N+1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
        }

        createTable();
        sb.append(listLIS.size()).append("\n");
        findLIS();
        System.out.println(sb);
    }

    private static void findLIS(){
        Stack<Integer> s = new Stack<>();
        int length = listLIS.size();
        for(int i=N; i>=1; i--){
            if(indexOrder[i]==length){
                length--;
                s.push(arr[i]);
            }
        }
        while(!s.isEmpty()){
            sb.append(s.pop()).append(" ");
        }
    }

    private static void createTable(){
        indexOrder[1] = 1;
        listLIS.add(arr[1]);

        for(int i=2; i<=N; i++){
            //만약 이전거보다 크다면 indexOrder를 전거 +1 해줌.
            //leastLIS도 보고 갱신해줌.
            int current = arr[i];
            int bigestInLIS = listLIS.get(listLIS.size()-1);
            if(current > bigestInLIS){
                listLIS.add(current);
                indexOrder[i] = listLIS.size();
            }else if(current == bigestInLIS){
                indexOrder[i] = listLIS.size();
            }else {
                parametricSearch(0, listLIS.size()-1, i);
            }
        }
    }

    private static void parametricSearch(int left, int right, int index) {
        int mid;
        int key = arr[index];

        while (left < right){
             mid = (left+right)/2;

             if(listLIS.get(mid) >= key){
                 right= mid-1;
             }else{
                 left = mid;
             }
        }
        listLIS.set(left, key);
        indexOrder[index] = left+1;
    }
}
