package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1202 {
    static class Jewel  {
        int weight, value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight(){
            return this.weight;
        }
    }

    static int N, K;
    static Jewel[] jewels;
    static PriorityQueue<Jewel> jewelPriorityQueue;
    static int[] bags;
    public static void main(String[] args) throws IOException {
        jewelPriorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new Jewel[N];
        bags = new int[K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(jewels, Comparator.comparingInt(Jewel::getWeight));
        findMaxValue();
    }

    public static void findMaxValue(){
        long result = 0;
        int bagCount = 0;
        int idx = 0;

        while(bagCount < K){
            //1. 무게가 허용되는 부분까지 담는다.
            while(idx < N && jewels[idx].weight <= bags[bagCount]){
                jewelPriorityQueue.add(jewels[idx++]);
            }
            //2. 더이상 허용되지 않는 무게에 도달하면 pq의 맨 위에 있는 애를 result에 더해준다.
            if(!jewelPriorityQueue.isEmpty()){
                result+= jewelPriorityQueue.poll().value;
            }
            bagCount++;
        }

        System.out.println(result);
    }


}

