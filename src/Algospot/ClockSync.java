package Algospot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ClockSync {
    final static int BIGNUM = 10000000;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c= Integer.parseInt(br.readLine());
            long result;
            String[] input;
            int[][] button = {
                    {0,1,2,-1,-1},{3,7,9,11,-1},{4,10,14,15,-1},{0,4,5,6,7},
                    {6,7,8,10,12},{0,2,14,15,-1},{3,14,15,-1,-1},{4,5,7,14,15},
                    {1,2,3,4,5},{3,4,5,9,13}
            };
            int[] clocks = new int[16];
            int next=0;

            for(int i=0; i<c; i++){
                input = br.readLine().split(" ");
                for(int j=0; j<16; j++){
                    clocks[j] = Integer.parseInt(input[j]);
                }
                result = clockRotate(0,clocks, button, next);
                if(result==BIGNUM)System.out.println(-1);
                else System.out.println(result);
            }
        }catch(IOException err){
            err.printStackTrace();
        }
    }

    //count : 총 버튼 누른 횟수
    //clocks: 현재 시계들이 가리키는 숫자를 저장한 배열
    //button: button마다 누르는 clocks를 저장해놓은 배열
    //number: 각버튼당 누른 횟수를 저장한 배열
    public static int clockRotate(int count,int[] clocks, int[][] button,int next){
        int[] temp  = new int[10];
        int minimum= BIGNUM;

        //모두 다 12시 가리키고 있으면 종료.
        boolean isAll = true;
        for(int i=0; i<16; i++){
            if(clocks[i]%4!=0){
                isAll = false;
                break;
            }
        }
        if(isAll==true) return count;
        if(next==10) return BIGNUM;

        //한 버튼을 3번 이하의 횟수로 누르면서 다음 번호로 넘어간다.
            for(int j=0; j<4; j++) {
                for (int k = 0; k < 5; k++) {
                    if (button[next][k] == -1) break;
                    clocks[button[next][k]] += 3 * j;
                }
                temp[j] = clockRotate(count+j, clocks, button, next+1);
                for (int k = 0; k < 5; k++) {
                    if (button[next][k] == -1) break;
                    clocks[button[next][k]] -= 3 * j;
                }
                minimum = Math.min(temp[j],minimum);
            }


        return minimum;
    }
}
