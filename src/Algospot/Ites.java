package Algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Ites {
    static int C,K,N;
    static final int QSIZE =  5000000;
    public static class Q {
        int[] queue = new int[QSIZE];
        int front=0, rear=0;
        public void addQ(int num){
            queue[front] = num;
            front = (front+1)%QSIZE;
        }
        public void removeQ(){
            rear = (rear+1)%5000000;
        }
        public int peekQ(){
            return queue[rear];
        }

    }
    public static class RandomGenerate {
        long rng = 1983;

        public int next(){
            int ret = (int) (this.rng%10000 +1);
            this.rng = (long)((rng * 214013 + 2531011) % Math.pow(2,32));

            return ret;
        }

//        public int findSubset(){
//            RandomGenerate randomNum = new RandomGenerate();
//            Queue<Integer> queue = new LinkedList<>();
//            int sum=0, ret = 0;
//            for(int i=0; i<N; i++){
//                int newNum = randomNum.next();
//                queue.add(newNum);
//                sum += newNum;
//
//                while(sum>K){
//                    sum -= queue.peek();
//                    queue.remove();
//                }
//                if(sum==K)ret++;
//            }
//            return ret;
//        }

        public int findSubset(){
            RandomGenerate randomNum = new RandomGenerate();
            Q queue = new Q();
            int sum=0, ret = 0;
            for(int i=0; i<N; i++){
                int newNum = randomNum.next();
                queue.addQ(newNum);
                sum += newNum;

                while(sum>K){
                    sum -= queue.peekQ();
                    queue.removeQ();
                }
                if(sum==K)ret++;
            }
            return ret;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        RandomGenerate rng = new RandomGenerate();
        for(int i=0; i<C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            System.out.println(rng.findSubset());
        }
    }
}
