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
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> listLIS = new ArrayList<>();
    static int[] indexOrder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            arr.add(input);
        }
        indexOrder = new int[N];
        createTable();
        sb.append(listLIS.size()).append("\n");

        findLIS();

        System.out.println(sb);
    }
    static void findLIS(){
        Stack<Integer> s = new Stack<>();
        int length = listLIS.size();
        for(int i=N-1; i>=0; i--){
            if(indexOrder[i]==length){
                length--;
                s.push(arr.get(i));
            }
        }
        for(int i=0; i<N; i++)
            System.out.println(indexOrder[i]);
        for(int i=0; i<listLIS.size(); i++)
            System.out.println(listLIS.get(i));
        while(!s.isEmpty()){
            sb.append(s.pop()).append(" ");
        }
    }

    public static void createTable(){
        indexOrder[0] = 1;
        listLIS.add(arr.get(0));

        for(int i=1; i<N; i++){
            //만약 이전거보다 크다면 indexOrder를 전거 +1 해줌.
            //leastLIS도 보고 갱신해줌.
            int current = arr.get(i);
            int bigestInLIS = listLIS.get(listLIS.size()-1);
            if(current > bigestInLIS){
                listLIS.add(current);
                indexOrder[i] = listLIS.size();
            }else if(current == bigestInLIS){
                indexOrder[i] = listLIS.size();
            }else {
                binarySearch(0, listLIS.size()-1, i);
            }
        }
    }

    private static void binarySearch(int left, int right, int index) {
        int mid;
        int key = arr.get(index);
        while (left < right){
             mid = (left+right)/2;

             if(listLIS.get(mid)>= key){
                 right=mid;
             }else{
                 left = mid+1;
             }
        }
        listLIS.set(left, key);
        indexOrder[index] = left+1;
    }
}
