package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1915 {
    static char[][] map;
    static int[][] dp;
    static int n,m;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        dp = new int[n][m];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            int acc = 0;
            for(int j=0; j<m; j++){
                map[i][j] = input.charAt(j);
                if(map[i][j]=='1')acc++;
                else acc=0;
                dp[i][j] = acc;
            }
        }

        int result = findMaxSquare();
        System.out.println(result * result);
    }

    public static int findMaxSquare(){
        int ret = 0;
        //nxm 직사각형에서 count*count의 정사각형 찾기.
        for(int i=0; i<n; i++){
            for(int j=m-1; j>=0; j--){

                int count = 0;
                //만약 1이 이어진 개수가 0이 아닌 곳을 찾았다면
                if(dp[i][j]!=0){
                    //현재 위치를 저장하고 최대 가능한 변의 길이를 저장해놓는다..
                    count=1;
                    int currentPos = i;
                    int maximumLine = dp[i][j];
                    //dp i에서 i+dp[i][j]까지 확인한다.
                    for(int k=i+1; k<currentPos + maximumLine; k++) {
                        //변의 길이가 너무 긴 경우 out되므로 k가 n에 도달하면 break;
                        if(k==n)break;
                        //변의 길이가 maximumLine에 도달했을 때.
                        if(count>=maximumLine){
                            break;
                        }

                        //이어져있는 1의 개수가 maximum과 크거나 같을 때.
                        if(dp[k][j]>=maximumLine){
                            ++count;
                        }

                        //짧을 때 -> 여기 처리가 문제인듯.
                        else{
                            maximumLine = dp[k][j];
                            if(count<maximumLine)++count;
                        }
                    }
                }
                ret = Math.max(count, ret);
            }
        }
        return ret;
    }
}
