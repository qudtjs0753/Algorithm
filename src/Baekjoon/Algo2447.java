package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Algo2447 {

    //i%3=1인 줄 마다 빈칸 뚫기.
    public static void makeHole(char[][] arr, int n, int y, int x){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[y+i][x+j]= ' ';
            }
        }
    }
    public static void makeSquare(char[][] arr,int n,int line,int part,int y,int x){
        if(line==1 && part==1)makeHole(arr,n,y,x);
        else if(n==1){
                    if(line==1 && part==1){
                        arr[y][x] = ' ';
                    }
                    else{
                        arr[y][x] = '*';
                    }

        }
        else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    makeSquare(arr, n/3, i,j, y+ (n/3)*i,x+(n/3)*j);
                }
            }
        }
    }

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N+1];
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    makeSquare(arr,N/3,i,j,(N/3)*i,(N/3)*j);
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }
            System.out.println(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
