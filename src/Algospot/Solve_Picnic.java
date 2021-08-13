package Algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solve_Picnic {
    //taken[i] : i번째 학생이 짝을 이미 찾았으면 true, 아니면 false
    public static int countPairings(int N,boolean[] taken,boolean[][] areFriends){
        //남은 학생들 중 가장 번호가 빠른 학생
        //이 아이디어 잘 보기.
        int firstFree = -1;
        for(int i=0; i<N; ++i){
            if(!taken[i]){
                firstFree = i;
                break;
            }
        }
        //기저 사례 : 모든 학생이 짝 찾으면 종료
        if(firstFree == -1) return 1;
        int ret = 0;

        for(int pairWith = firstFree+1; pairWith <N; ++pairWith){
            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings(N, taken, areFriends);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }
    public static void main(String[] args){
        try{
            int N, M;
            int c, friendA, friendB;
            String[] friends;
            String[] nums;
            boolean[] taken= new boolean[10];
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            c = Integer.parseInt(br.readLine());
            for(int i=0; i<c; i++){
                boolean[][] areFriends = new boolean[10][10];
                nums = br.readLine().split(" ");
                N = Integer.parseInt(nums[0]);
                M = Integer.parseInt(nums[1]);
                friends = br.readLine().split(" ");

                for(int j=0; j<2*M; j+=2){
                    friendA = Integer.parseInt(friends[j]);
                    friendB = Integer.parseInt(friends[j+1]);
                    areFriends[friendA][friendB] = true;
                    areFriends[friendB][friendA] = true;
                }

                System.out.println(countPairings(N,taken,areFriends));
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
