package Baekjoon;

import java.io.*;
public class Algo1206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("\\.");
            arr[i] = Integer.parseInt(input[0].concat(input[1]));
        }

        for(int personCount = 1; personCount<=1000; personCount++) {
            if(binarySearch(personCount, arr)) {
                System.out.println(personCount);
                return;
            }
        }
    }
    private static boolean binarySearch(int personCount, int[] arr) {
        for(int currentAverage : arr) {
            int left = 0, right = personCount*10;
            int tempAverage = 0;

            while(left<=right) {
                int sum = (left + right) / 2;
                tempAverage = (sum * 1000) / personCount;

                if(tempAverage == currentAverage) {
                    break;
                }else if ( currentAverage < tempAverage) {
                    right = (sum - 1);
                }else {
                    left = (sum+1);
                }
            }
            if(tempAverage!=currentAverage) {
                return false;
            }
        }
        return true;
    }
}
