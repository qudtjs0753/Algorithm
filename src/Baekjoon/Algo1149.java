package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;
public class Algo1149 {
    public static class Color {
        int red, green, blue;
        Color(int red, int green, int blue){
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }
    static int N;
    static int[][] allHouse;
    static Color[] house;

    public static void findMin(int index){
        if(index==0){
            allHouse[0][0] = house[0].red;
            allHouse[1][0] = house[0].green;
            allHouse[2][0] = house[0].blue;
        }
        else{
            if(allHouse[0][index-1] == 0)findMin(index-1);
            allHouse[0][index] = house[index].red + Math.min(allHouse[1][index-1], allHouse[2][index-1]);
            allHouse[1][index] = house[index].green + Math.min(allHouse[0][index-1], allHouse[2][index-1]);
            allHouse[2][index] = house[index].blue + Math.min(allHouse[0][index-1], allHouse[1][index-1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        house = new Color[N];
        //최적의 배열 저장용.
        allHouse = new int[3][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            house[i] = new Color(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        findMin(N-1);
        int result = Math.min(Math.min(allHouse[0][N-1],allHouse[1][N-1]),allHouse[2][N-1]);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
