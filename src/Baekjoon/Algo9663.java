package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


//기저사례 1. 같은줄이면 x
//즉 x좌표 y좌표 둘중하나라도 같으면 안된다 -> 둘다 1~N까지 한개씩 가진다.
//  queen이 n개이기 때문에 x,y좌표 모두 0~n-1의 값을 하나씩 이용해야함을 의미.
//기저사례 2. 대각선상에 존재하면 안된다. 즉 x-y의 값이 모두 달라야한다. 이때 절대값을 사용해야한다!!
//기저사례 3. N개 다 고려 끝나면 끝.
//x는 순서 고정시켜놓고 y만 순서 바꿔주면서 기저사례 3애 대해 개수를 세준다.
public class Algo9663 {

    public static boolean findIndex(int num,int minus,int plus,int[] sub,int[] sum){
        for(int i=0; i<num; i++){
            if(sub[i]==minus){
                return true;
            }
            if(sum[i]==plus){
                return true;
            }
        }
        return false;
    }
    public static int noDieQueen(int N,int x,int[] sub,boolean[] yAxis,int[] sum){
        boolean equal = false;
        //x-y 확인  - 문제없음.
        if(x>1)equal = findIndex(x-1,sub[x-1],sum[x-1],sub,sum);
        //중간에 x-y 같은 원소 있을 때
        if(equal) return 0;
        //N개 다 올려놨을 때
        if(x==N) return 1;

        int result = 0;
        //x에 각각의 y를 대입하는 단계
        for(int i=0; i<N;i++){
            if(!yAxis[i]){
                sub[x]=i-x;
                sum[x]=i+x;
                yAxis[i]=true;
                result+=noDieQueen(N,x+1,sub,yAxis,sum);
                yAxis[i]=false;
                sum[x]=-1;
                sub[x]=N+1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        try{
            int[] sub = new int[15];
            int[] sum = new int[15];
            boolean[] yAxis = new boolean[15];

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                sub[i] = N+1;
                sum[i] = -1;
                yAxis[i] = false;
            }
            int total = noDieQueen(N, 0, sub,yAxis,sum);
            System.out.println(total);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
