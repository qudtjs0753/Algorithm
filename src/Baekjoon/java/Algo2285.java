package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2285 {
    private static class Village {
        long pos, numOfPeople;

        public Village(long pos, long numOfPeople) {
            this.pos = pos;
            this.numOfPeople = numOfPeople;
        }
    }
    static long N, allPeople =0, sumOfPeople=0;
    static ArrayList<Village> village = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            village.add(new Village(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
            allPeople +=village.get(i).numOfPeople;
        }
        Collections.sort(village, Comparator.comparingLong(o -> o.pos));
        for(int i=0; i<N; i++){
            sumOfPeople+=village.get(i).numOfPeople;
            if(sumOfPeople * 2 >= allPeople){
                System.out.println(village.get(i).pos);
                return;
            }
        }

    }


}
