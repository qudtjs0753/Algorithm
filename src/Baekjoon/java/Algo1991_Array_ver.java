package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1991_Array_ver {
    static int[][] arr= new int[50][2];
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        for(int i=0; i<50; i++){
            for(int j=0; j<2; j++)
                arr[i][j] = -1;
        }
        while(N>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char x = st.nextToken().charAt(0);
            char y = st.nextToken().charAt(0);
            char z = st.nextToken().charAt(0);
            if(y!='.')
                arr[x - 'A'][0] = y - 'A';
            if(z!='.')
                arr[x - 'A'][1] = z - 'A';
            N--;
        }
        printPreOrder(0);
        bw.write('\n');
        printInOrder(0);
        bw.write('\n');
        printPostOrder(0);
        bw.flush();
        bw.close();
    }
    public static void printPreOrder(int index) throws IOException{
        if(index!=-1){
            bw.write((char)(index+'A'));
            printPreOrder(arr[index][0]);
            printPreOrder(arr[index][1]);
        }

    }
    public static void printInOrder(int index) throws IOException{
        if(index!=-1) {
            printInOrder(arr[index][0]);
            bw.write((char)(index+'A'));
            printInOrder(arr[index][1]);
        }
    }
    public static void printPostOrder(int index) throws IOException{
        if(index!=-1) {
            printPostOrder(arr[index][0]);
            printPostOrder(arr[index][1]);
            bw.write((char)(index+'A'));
        }
    }
}
