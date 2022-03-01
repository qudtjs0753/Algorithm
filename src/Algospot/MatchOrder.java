package Algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class MatchOrder {
    static int N, C;
    static ArrayList<Integer> russia, korea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        C = Integer.parseInt(br.readLine());
        while(C-- > 0) {
            N = Integer.parseInt(br.readLine());
            russia = new ArrayList<>();
            korea = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                russia.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(russia, Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                korea.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(korea, Collections.reverseOrder());
            sb.append(getMaxwinnter()).append("\n");
        }
        System.out.print(sb);
    }

    private static int getMaxwinnter() {
        int last = korea.size()-1, first = 0;
        int idx = 0;
        int count = 0;
        while(first <= last){
            if(russia.get(idx)>korea.get(first)){
                last--;
            }else{
                first++;
                count++;
            }
            idx++;
        }

        return count;
    }
}
