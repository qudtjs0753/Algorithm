package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1039 {
    static int N, K;
    static Queue<ValueToSwap> queue = new LinkedList<>();
    static boolean[][] checked;



    static class ValueToSwap {
        int number;
        int count;
        ValueToSwap(int number, int count){
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //숫자가 변환 되었을 때 그 숫자 값을 행의 위치
        //열의 위치는 그 숫자 값이 몇번째로 변환된 것인지 나타내는 위치이다.

        checked = new boolean[1000001][11];

        System.out.println(findMaximumNumberByBfs());

    }

    public static int findMaximumNumberByBfs(){

        //교환하지 않은 생 입력상태의 값을 Queue에 저장한다.
        int ret = -1;
        queue.add(new ValueToSwap(N, 0));
        checked[N][0] = true;

        //BFS로 앞자리부터 하나하나 교체해가면서 탐색한다.
        //포문에서 N에 도달하지 못하면 나와서 다시 N에 도달할 때 까지 계속 수행.
        while(!queue.isEmpty()){
            //number값을 string으로 변환한다.
            int swappedVal;
            ValueToSwap nextQueue = queue.poll();
            String numTypeOfString = Integer.toString(nextQueue.number);
            //number의 길이만큼 이중포문을 돌린다.
            for(int i=0; i<numTypeOfString.length()-1; i++){
                if(nextQueue.count==K){
                    ret = Math.max(ret, nextQueue.number);
                    break;
                }
                for( int j=i+1; j<numTypeOfString.length(); j++){
                    //K값에 도달했을 때.
                    numTypeOfString = swap(nextQueue.number, i, j);
                    swappedVal = Integer.parseInt(numTypeOfString);

                    //만약 바꿨는데 맨 앞자리가 0이거나, 바꿨던게 이미 똑같은 순서에서 바뀐적이 있으면 넘어간다.
                    if(numTypeOfString.charAt(0) == '0' || checked[swappedVal][nextQueue.count+1]) continue;


                    checked[swappedVal][nextQueue.count+1] = true;
                    queue.add(new ValueToSwap(swappedVal, nextQueue.count+1));
                }
            }
        }
        return ret;
    }

    private static String swap(int number, int idx1, int idx2) {
        StringBuilder sb  = new StringBuilder().append(number);
        char temp = sb.charAt(idx1);
        sb.setCharAt(idx1, sb.charAt(idx2));
        sb.setCharAt(idx2, temp);

        return sb.toString();
    }

}


