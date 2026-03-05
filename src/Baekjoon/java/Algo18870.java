package Baekjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.List;

public class Algo18870 {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num;
            List<Integer> arr = new ArrayList<Integer>();
            int count=0;
            for(int i=0; i<N; i++){
                num = Integer.parseInt(st.nextToken());
                arr.add(num);
                count++;
            }
            //hashset이 set중에서 성능이 가장 좋아 이걸로 변경
            List<Integer> removeDuplicated = new ArrayList<Integer>(new HashSet<Integer>(arr));
            StringBuilder result = new StringBuilder();
            removeDuplicated.sort(null);
            for(int i=0; i<N; i++){
                result.append( Collections.binarySearch(removeDuplicated, arr.get(i))).append(" ");
            }
            System.out.println(result);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
