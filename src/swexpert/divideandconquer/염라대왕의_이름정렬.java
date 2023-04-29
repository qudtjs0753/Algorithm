package swexpert.divideandconquer;

import java.io.*;
public class 염라대왕의_이름정렬 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase<=T; testCase++) {
            int length = Integer.parseInt(br.readLine());
            String[] words = new String[length];
            for (int i=0; i<length; i++) {
                words[i] = br.readLine();
            }

            mergeSort(words);
            sb.append("#").append(testCase).append("\n");
            String prev = "";
            for(String word: words) {
                if (!word.equals(prev)) {
                    sb.append(word).append("\n");
                }

                prev = word;
            }
        }
        System.out.println(sb);
    }

    static void mergeSort(String[] arr) {
        if (arr.length == 1) {
            return;
        }
        int center = arr.length / 2;
        String[] head = arrCopy(arr, 0, center);
        String[] tail = arrCopy(arr, center, arr.length);
        mergeSort(head);
        mergeSort(tail);

        int headPtr = 0;
        int tailPtr = 0;
        int index = 0;
        while (index < arr.length) {
            if (headPtr == head.length) {
                arr[index] = tail[tailPtr];
                tailPtr++;
            }
            else if(tailPtr == tail.length) {
                arr[index] = head[headPtr];
                headPtr++;
            }else {
                if(compare(head[headPtr],tail[tailPtr])) {
                    arr[index] = tail[tailPtr];
                    tailPtr++;
                }
                else {
                    arr[index] = head[headPtr];
                    headPtr++;
                }
            }
            index++;
        }
    }

    static String[] arrCopy(String[] arr, int start, int end) {
        String[] result = new String[end - start];
        for (int i=start; i<end; i++) {
            result[i-start] = arr[i];
        }
        return result;
    }

    static boolean compare(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return s1.length() > s2.length();
        }

        for (int i=0; i<Math.max(s1.length(), s2.length()); i++) {
            char c1 = getChar(s1, i);
            char c2 = getChar(s2, i);
            if (c1 != c2) {
                return c1 > c2;
            }
        }
        return true;
    }

    static char getChar(String s, int index) {
        if (index >= s.length()) {
            return 0;
        }
        return s.charAt(index);
    }
}
