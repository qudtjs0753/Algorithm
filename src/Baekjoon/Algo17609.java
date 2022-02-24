package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo17609 {


    static int N;
    static String input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            input = br.readLine();
            sb.append(isPalindrome(0,-1)).append("\n");
        }

        System.out.println(sb);
    }

    //투포인터 사용
    //한 문자열만 삭제해서 회문으로 만들어야함.
    //양쪽 끝부터 비교하다가 다른 문자열이 나오면 왼쪽 문자열을 제외한 경우와 오른쪽 문자열을 제외한 경우를 비교해서
    //Palindrome 체크값이 가장 작은녀석을 고른다.
    private static int isPalindrome(int depth,int exceptIdx) {
        if(depth==2)return 2;

        int left = 0, right= input.length()-1;

        while(left<=right){
            if(exceptIdx==left){
                left++;
                continue;
            }else if(exceptIdx==right){
                right--;
                continue;
            }
            if(input.charAt(left)==input.charAt(right)){
                left++; right--;
            }else{
                return Math.min(isPalindrome(depth+1, left), isPalindrome(depth+1, right));
            }
        }

        return depth;
    }
}
