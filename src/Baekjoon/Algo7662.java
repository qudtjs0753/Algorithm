package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo7662 {
    static int T, k, addCount, deleteCountMax, deleteCountMin;
    static PriorityQueue<Integer> pqMax;
    static PriorityQueue<Integer> pqMin;
    static Map<Integer, Integer> counter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            k = Integer.parseInt(br.readLine());
            addCount = 0;
            deleteCountMax = 0;
            deleteCountMin = 0;

            pqMax = new PriorityQueue<>(Collections.reverseOrder());
            pqMin = new PriorityQueue<>();
            counter = new HashMap<>();

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0);

                if(oper=='I')
                    insert(Integer.parseInt(st.nextToken()));
                else if(oper=='D')
                    delete(Integer.parseInt(st.nextToken()));

            }

            //없는 숫자들을 모두 지워준다.
            deleteEmptyNumberInPQ();

            if(pqMax.isEmpty() || pqMin.isEmpty())
                sb.append("EMPTY").append("\n");
            else
                sb.append(pqMax.peek()).append(" ").append(pqMin.peek()).append("\n");
        }
        System.out.println(sb);
    }

    private static void delete(int whereToDelete) {
        if(whereToDelete==1){
            while(!pqMax.isEmpty()){
                int deleteValue = pqMax.poll();
                if(counter.get(deleteValue)> 0){
                    counter.put(deleteValue,counter.get(deleteValue)-1);
                    break;
                }
            }
        }else{
            while(!pqMin.isEmpty()){
                int deleteValue = pqMin.poll();
                if(counter.get(deleteValue)> 0){
                    counter.put(deleteValue,counter.get(deleteValue)-1);
                    break;
                }
            }
        }
    }

    private static void insert(int input) {
        pqMax.add(input);
        pqMin.add(input);
        counter.put(input, counter.getOrDefault(input, 0)+1);
        addCount++;
    }

    private static void deleteEmptyNumberInPQ(){
        while(!pqMax.isEmpty()){
            if(counter.get(pqMax.peek())!= 0){
                break;
            }
            pqMax.poll();
        }
        while(!pqMin.isEmpty()){
            if(counter.get(pqMin.peek())!= 0){
                break;
            }
            pqMin.poll();
        }
    }
}
