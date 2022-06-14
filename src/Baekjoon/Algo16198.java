package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo16198 {
    static int N;
    static long maxEnergy = 0;
    static ArrayList<Integer> marbles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            marbles.add(Integer.parseInt(st.nextToken()));
        }

        findMaxEnergy();

        System.out.println(maxEnergy);
    }

    private static void findMaxEnergy() {
        for(int i=1; i<N-1; i++){
            ArrayList<Integer> temp = new ArrayList<>();

            duplicate(temp, marbles, i);

            long sum = backTracking(1, temp) + marbles.get(i - 1) * marbles.get(i+1);
            maxEnergy = Math.max(sum, maxEnergy);
        }
    }

    private static long backTracking(int depth, ArrayList<Integer> arr){
        long ret = 0;
        if(depth<N-2){
            for(int i=1; i<arr.size()-1; i++){
                ArrayList<Integer> temp = new ArrayList<>();

                duplicate(temp, arr, i);

                long sum = backTracking(depth+1, temp) + arr.get(i - 1) * arr.get(i+1);
                ret = Math.max(sum, ret);
            }
        }
        return ret;
    }

    //선택한 구슬을 제외하고 복제
    private static void duplicate(ArrayList<Integer> temp,ArrayList<Integer> arr, int removeMarble){
        for(int j=0; j<arr.size();j++){
            if(removeMarble==j)continue;
            temp.add(arr.get(j));
        }
    }
}
