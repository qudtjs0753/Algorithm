package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo15686 {
    static int N,M,answer = Integer.MAX_VALUE;
    static ArrayList<Coordination>
            houses = new ArrayList<>(), chickenRestaurants = new ArrayList<>(),temp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int y=1; y<=N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<=N; x++){
                int input = Integer.parseInt(st.nextToken());
                if(input==1){
                    houses.add(new Coordination(y,x));
                }else if(input==2){
                    chickenRestaurants.add(new Coordination(y,x));
                }
            }
        }

        for(int i = 0; i< chickenRestaurants.size(); i++){
            temp.add(chickenRestaurants.get(i));
            findSmallest();
            findAll(1, i);
            temp.remove(temp.size()-1);
        }

        System.out.println(answer);
    }
    //최대 2^M * 2N -> bruteforce로 충분
    //1. 리스트에 집 위치 저장
    //2. 리스트에 치킨집 위치 저장.
    //3. 치킨집 추가하고 빼면서 체크.
    private static void findAll(int chickenNum, int idx) {
        if(chickenNum>=M)return;
        for(int i = idx+1; i< chickenRestaurants.size(); i++){
            temp.add(chickenRestaurants.get(i));
            findSmallest();
            findAll(chickenNum+1, i);
            temp.remove(temp.size()-1);
        }

    }

    private static void findSmallest(){
        int chickenLength = 0;
        for(Coordination currentHouse : houses){
            int minChickenLengthOfHouse = Integer.MAX_VALUE;
            for(Coordination currentRestaurant : temp){
                int dist = Math.abs(currentHouse.y- currentRestaurant.y)
                        + Math.abs(currentHouse.x- currentRestaurant.x);
                minChickenLengthOfHouse = Math.min(dist, minChickenLengthOfHouse);
            }
            chickenLength += minChickenLengthOfHouse;
        }
        answer = Math.min(chickenLength, answer);
    }


    private static class Coordination {
        int y, x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
