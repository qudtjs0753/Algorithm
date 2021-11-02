package College;

import java.io.*;
import java.util.StringTokenizer;

public class AllPairsShortest {
    static int N;
    static int[][] d;

    public static void findShortest(){
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                {
                    if (i != k) {
                        for (int j = 0; j < N; j++) {
                            if (j != i && j != k)
                                d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
                        }
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        d= new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findShortest();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(d[i][j]+ " ");
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
}
