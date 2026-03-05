package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11054 {
    static int N, longestLength=1;
    static int[] arr,memoIncrease, memoDecrease;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        memoIncrease = new int[N + 1];
        memoDecrease = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memoIncrease[i] = 1;
            memoDecrease[i] = 1;
            arr[i] = Integer.parseInt(st.nextToken());
        }


        longestLength = Math.max(findLongestBitonic(),longestLength);

        System.out.println(longestLength);
    }

    private static int findLongestBitonic(){
        //상승,하강확인.
        int length = 1;

        findLIS();
        findLDS();

        for(int i=1; i<=N; i++){
            length = Math.max(memoIncrease[i]+memoDecrease[i]-1,length);
        }
        return length;
    }

    private static void findLIS() {
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(arr[i] > arr[j])
                    memoIncrease[i] = Math.max(memoIncrease[i],memoIncrease[j]+1);

            }
        }
    }
    private static void findLDS() {
        for(int i=N; i>=1; i--){
            for(int j=N; j>i; j--){
                if(arr[i] > arr[j])
                    memoDecrease[i] = Math.max(memoDecrease[i],memoDecrease[j]+1);
            }
        }
    }

}
