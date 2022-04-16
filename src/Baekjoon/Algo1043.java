package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1043 {
    static int N,M, result = 0;
    static int[] parent;
    static boolean[] isKnown;
    static ArrayList<ArrayList<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        isKnown = new boolean[N+1];
        for(int i=0; i<=N; i++)parent[i] = i;

        //known people 정보 입력
        st = new StringTokenizer(br.readLine());
        int knownNum = Integer.parseInt(st.nextToken());
        for(int i=0; i<knownNum; i++)
            isKnown[Integer.parseInt(st.nextToken()) ] = true;

        //party 정보 입력
        for(int i=0; i<M; i++){
            Integer hasTruth = -1;
            ArrayList<Integer> party = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                party.add(Integer.parseInt(st.nextToken()));
                if(isKnown[party.get(party.size()-1)]){
                    hasTruth = party.get(party.size()-1);
                }
            }

            //만약 진실을 아는 사람이 있는 파티인 경우.
            if(hasTruth!=-1){
                for(Integer person : party){
                    union(person, hasTruth);
                }
                continue;
            }
            if(party.size()>=1) {
                int anotherPerson = party.get(0);
                for(Integer person : party){
                    union(person,anotherPerson);
                    anotherPerson = person;
                }
            }
            parties.add(party);
        }



        checkMaximum();

        System.out.println(result);
    }

    private static void checkMaximum() {
        for(int i=parties.size()-1; i>=0; i--){
            int canLie = -1;
            for(int person : parties.get(i)){
                if(isKnown[find(person)]){
                    canLie = find(person);
                    break;
                }
            }
            if(canLie!=-1){
                for(int person : parties.get(i)){
                    union(person, canLie);
                }
            }else result++;
        }
    }

    private static void union(Integer person1, Integer person2) {
        int parent1 = find(person1);
        int parent2 = find(person2);
        if(isKnown[parent1])parent[parent2] = parent1;
        else if(isKnown[parent2])parent[parent1] = parent2;
        else if(parent1 > parent2)parent[parent1] = parent2;
        else parent[parent2] = parent1;
    }

    private static int find(int parent1){
        if(parent[parent1] == parent1)return parent1;
        else return parent[parent1] = find(parent[parent1]);
    }
}
