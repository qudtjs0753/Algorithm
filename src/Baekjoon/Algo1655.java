package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: kbs
 */
public class Algo1655 {
    static int N;
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            //중간값을 구하기 위해선 어떻게 해야할까?
            //값을 받는 즉시 정렬이 필요.
            //우선순위 큐.
            //우선순위를 어떻게 짜야할까.
                //min heap과 max heap 총 두개를 둔다.
                //max heap의 최상단이 중간값을 가리키도록 해야한다
                    //우선 minHeap에는 중간값보다 큰 값만을 담고
                    //maxHeap에는 중간값보다 작거나 같은 값을 담는다.
                    //maxHeap에 제일 먼저 담고 그다음 minHeap에 담는다.
            if(minHeap.size()==maxHeap.size()) maxHeap.add(input);
            else minHeap.add(input);

            if(!maxHeap.isEmpty()&&!minHeap.isEmpty()){
                if(maxHeap.peek() > minHeap.peek()){
                    swap();
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.print(sb);
    }

    private static void swap() {
        int temp = maxHeap.poll();
        maxHeap.add(minHeap.poll());
        minHeap.add(temp);
    }


}
