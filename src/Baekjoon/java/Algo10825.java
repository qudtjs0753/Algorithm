package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Algo10825 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Student> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ko = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            arr.add(new Student(name, ko, en, math));

        }
        Collections.sort(arr);

        for(int i=0; i<N; i++) {
            sb.append(arr.get(i).name).append("\n");
        }
        System.out.print(sb);
    }


}

class Student implements Comparable<Student> {
    String name;
    int ko, en, math;

    public Student(String name, int ko, int en, int math) {
        this.name = name;
        this.ko = ko;
        this.en = en;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        if(this.ko!=o.ko) {
            return -this.ko+o.ko;
        }

        if(this.en!=o.en) {
            return this.en-o.en;
        }

        if(this.math!=o.math) {
            return -this.math + o.math;
        }

        return name.compareTo(o.name);
    }
}
