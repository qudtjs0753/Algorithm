package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1208 {
    static int N, S;
    static long result=0;
    static int[] arr;
    static ArrayList<Integer> leftSum = new ArrayList<>(), rightSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        addSequence(0, N/2, 0, leftSum);
        addSequence(N/2, N, 0, rightSum);

        Collections.sort(leftSum);
        Collections.sort(rightSum);

        countSum();

        if(S==0)result--;

        System.out.println(result);
    }

    private static void countSum() {
        int left = 0, right = rightSum.size()-1;

        while(left<leftSum.size() && right >= 0){
            int sumOfLeft = leftSum.get(left);
            int sumOfRight = rightSum.get(right);
            long sum = sumOfLeft + sumOfRight;
            if(sum==S){
                long countLeft = 0, countRight = 0;
                while(left<leftSum.size() && leftSum.get(left)==sumOfLeft){
                    left++;
                    countLeft++;
                }
                while(right>=0 && rightSum.get(right)==sumOfRight){
                    right--;
                    countRight++;
                }
                result += countLeft*countRight;
            }
            else if(sum < S){
                left++;
            }else {
                right--;
            }
        }
    }

    private static void addSequence(int start, int end, int sum, ArrayList<Integer> list) {
        if(start==end){
            list.add(sum);
        }else{
            addSequence(start+1, end, sum+arr[start], list);
            addSequence(start+1, end, sum, list);
        }
    }
}
