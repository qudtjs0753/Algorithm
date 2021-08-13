package Algospot;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Picnic {
    //기저사례 1. 친구가 없을때
    //기저사례 2. 친구를 다 찾았을 때.
    public static int matchAll(boolean[][] arr, int N, boolean[] complete,int student){
        //짝을 다 맞췄으면 반환
        boolean findAll = true;
        for(int i=0;i<N;i++){
            if(!complete[i]) findAll=false;
        }
        if(findAll) return 1;

        //짝 탐색
        int sum=0;
        for(int i=0; i<N; i++){
            //앞에서 추가한 친구목록과 겹치는지 체크.
            if(complete[student]){
                sum += matchAll(arr,N,complete,student+1);
                break;
            }
            else if(!complete[i]);
            else{
                //친구목록에 있으면 add
                if(arr[student][i]){
                    complete[i] = true;
                    complete[student] = true;
                    sum += matchAll(arr,N,complete,student+1);
                    complete[i] = false;
                    complete[student] = false;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int C = Integer.parseInt(br.readLine());
            String[] num;
            String[] friends;
            int friendA;
            int friendB;
            boolean[] matchSet = new boolean[10];
            for(int i=0; i<C; i++){
                num = br.readLine().split(" ");
                int N = Integer.parseInt(num[0]);
                int M = Integer.parseInt(num[1]);
                boolean[][] match = new boolean[N][N];
                //원래 StringTokenizer로했는데 이거 java 공식문서에서 Legacy라고 권하지 않음.

                //친구 입력받고 match에다가 저장하는 부분.
                friends = br.readLine().split(" ");
                for(int j=0;j<2*M;j+=2){
                    friendA = Integer.parseInt(friends[j]);
                    friendB = Integer.parseInt(friends[j+1]);
                    match[friendA][friendB] = true;
                    match[friendB][friendA] = true;
                }
                System.out.println(matchAll(match,N,matchSet,0));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
