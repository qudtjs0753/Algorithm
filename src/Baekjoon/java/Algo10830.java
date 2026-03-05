package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo10830 {
    static Long B;
    static int N;
    static long[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new long[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                matrix[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] result = divideHalf(B);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static long[][] divideHalf(long n){
        if(n==2)
            return multiply(matrix,matrix);
        else if(n==1){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    matrix[i][j]%=1000;
                }
            }
            return matrix;
        }


        long[][] halfMatrix = divideHalf(n/2);

        if(n%2==1){
            return multiply(multiply(halfMatrix,halfMatrix),matrix);
        }else {
            return multiply(halfMatrix, halfMatrix);
        }
    }

    private static long[][] multiply(long[][] matrix1, long[][] matrix2){
        long[][] newMatrix = new long[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    newMatrix[i][j] += matrix1[i][k]*matrix2[k][j];
                }
                newMatrix[i][j]%=1000;
            }
        }

        return newMatrix;
    }
}
