import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Algo14500 {
    //by bruteforce
    //기저사례1. 4번 이동 완료시
    //기저사례2. 이동시 인덱스 범위 벗어났을 때
    //기저사례3. 이미 탐색한 블록을 만났을 때
    //예외사례 : 테트로미노 ㅗ 모양은 따로 볼 것.
    public static int findLargestByBruteForce(int[][] arr,boolean[][] check,int N, int M,int count,int y, int x){

        //3. 이미 탐색한 블록을 만났을 때 여기가 문제.
        if(check[y][x]) return 0;
        //1. 4번 이동 완료했을 때
        if(count==3)return arr[y][x];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        int max = 0;
        int[] sum = {arr[y][x],arr[y][x],arr[y][x],arr[y][x]};

        for(int i=0;i<4;i++){
            //2. 이동시 인덱스 범위 벗어났을 때
            if(y+dy[i]<0 || x+dx[i]<0 || y+dy[i]>N-1 || x+dx[i]>M-1);
            else{
                check[y][x] = true;
                sum[i] += findLargestByBruteForce(arr,check,N,M,count+1,y+dy[i],x+dx[i]);
                if(sum[i]>max)max=sum[i];
                check[y][x] = false;
            }
        }

        return max;
    }
    //예외사례 : 테트로미노 ㅗ 모양
    public static int exceptionPolynomio(int[][] arr,int N, int M,int y, int x){
        int[][] dx = {{-1,0,1},{-1,0,1},{0,-1,0},{0,1,0}};
        int[][] dy = {{0,1,0},{0,-1,0},{-1,0,1},{-1,0,1}};
        int max=0;
        int[] sum = {arr[y][x],arr[y][x],arr[y][x],arr[y][x]};

        for(int i=0;i<4; i++){
            for(int j=0;j<3;j++){
                if(y+dy[i][j]<0 || x+dx[i][j]<0 || y+dy[i][j]>N-1 || x+dx[i][j]>M-1) break;
                else{
                    sum[i] += arr[y+dy[i][j]][x+dx[i][j]];
                }
            }
            if(sum[i]>max)max=sum[i];
        }
        return max;
    }

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][M];
            boolean[][] check = new boolean[N][M];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    check[i][j] = false;
                }
            }
            int sum;
            int sumEx;
            int max = 0;
            int maxEx = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    sum = findLargestByBruteForce(arr,check,N,M,0,i,j);
                    if(sum>max)max=sum;
                    sumEx = exceptionPolynomio(arr,N,M,i,j);
                    if(sumEx>maxEx)maxEx=sumEx;
                }
            }
            if(maxEx>max)max=maxEx;
            System.out.println(max);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
