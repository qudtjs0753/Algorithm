package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1966 {
    static int T,N, queueOrder,priority;
    static ArrayList<Integer> order;
    static Queue<Document> q;

    static class Document {
        int priority;
        boolean isFind;

        public Document(int priority, boolean isFind) {
            this.priority = priority;
            this.isFind = isFind;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            queueOrder = Integer.parseInt(st.nextToken());
            order = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            q = new LinkedList<>();

            for(int i=0; i<N; i++){
                order.add(Integer.parseInt(st.nextToken()));
                if(i==queueOrder){
                    priority = order.get(i);
                    q.add(new Document(order.get(i),true));
                }else{
                    q.add(new Document(order.get(i),false));

                }
            }

            order.sort(Collections.reverseOrder());
            sb.append(checkOrder()).append("\n");
        }
        System.out.print(sb);
    }

    private static int checkOrder(){
        int index = 0;
        while(!q.isEmpty()){
            Document temp = q.poll();

            //중요도가 더 낮으면 다시 add.
            if(temp.priority<order.get(index)){
                q.add(temp);
            }else{
                if(temp.priority==priority && temp.isFind)return index+1;
                index++;
            }
        }
        return index+1;
    }

}
