package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo1713 {
    static int N,allRecommend;
    static ArrayList<Picture> frame = new ArrayList<>();
    static class Picture implements Comparable<Picture>{
        int student,recommendCount ,period;
        Picture(int student,int recommendCount, int period){
            this.student = student;
            this.recommendCount = recommendCount;
            this.period = period;
        }

        @Override
        public int compareTo(Picture o){
            if(this.recommendCount==o.recommendCount){
                return o.period-this.period;
            }
            return this.recommendCount-o.recommendCount;
        }
    }
    //정렬기준 1. 득표수
    //정렬기준 2. 있었던 기간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        allRecommend= Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            Picture student = new Picture(Integer.parseInt(st.nextToken()),1,1);
            insertPicture(student);
        }
        if(frame.size()>=2){
            Collections.sort(frame, new Comparator<Picture>() {
                @Override
                public int compare(Picture o1, Picture o2) {
                    return o1.student-o2.student;
                }
            });
        }


        for(int i=0; i<frame.size(); i++)
            sb.append(frame.get(i).student + " ");
        System.out.println(sb);
    }

    public static void insertPicture(Picture student){
        boolean find =false;
        for(int i=0; i<frame.size(); i++){
            if(frame.get(i).student == student.student){
                frame.get(i).recommendCount++;
                frame.get(i).period++;
                find = true;
            }
            frame.get(i).period++;
        }
        if(N==frame.size() && !find){
            Collections.sort(frame);
            frame.set(0, student);
            return;
        }
        else if(!find)
            frame.add(student);

    }
}
