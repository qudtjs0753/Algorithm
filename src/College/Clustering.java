package College;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Clustering {
    static int N,K;
    static Point[] points,clusters;
    static int[] distance;
    public static class Point implements Comparable<Point> {
        int x, y, index;
        Point(int x, int y, int index){
            this.x = x;
            this.y = y;
            this.index =index;
        }

        @Override
        public int compareTo(Point o) {
            return this.index - o.index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        distance = new int[N];
        points = new Point[N];
        clusters = new Point[K];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),i);
            distance[i] = Integer.MAX_VALUE;
        }
        clusters[0] = points[0];
        findClusters();
        Arrays.sort(clusters);
        for(int i=0; i<K; i++){
            bw.write(String.valueOf(clusters[i].x)+ " " + String.valueOf(clusters[i].y) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void findClusters(){
        double d;
        int maxIndex=0;
        for(int i = 0; i<K-1; i++){
            Point mid = clusters[i];
            for(int j=0; j<N; j++){
                if((d = Math.sqrt((mid.x-points[j].x)*(mid.x-points[j].x)
                    +(mid.y-points[j].y)*(mid.y-points[j].y)))<=distance[j]){
                        distance[j] =(int)d;
                }
            }
            for(int j=0; j<N; j++)
                if(distance[j]>distance[maxIndex])
                    maxIndex=j;

            clusters[i+1] = points[maxIndex];
        }
    }

}
