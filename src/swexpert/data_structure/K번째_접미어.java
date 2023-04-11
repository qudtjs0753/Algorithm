package swexpert.data_structure;

import java.io.*;
import java.util.*;

public class K번째_접미어 {

    static int resultLength = 0;
    static int K, count;
    static char[] result;
    static Trie startingPoint;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase<=T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            K = Integer.parseInt(br.readLine());
            count = 0;
            String input = br.readLine();
            result = new char[input.length()];
            startingPoint = new Trie();
            resultLength = 0;
            init(input);
            boolean canMade = startingPoint.dfs(0, startingPoint);

            if(!canMade) {
                sb.append("none");
            }else {
                for(int i=0; i<resultLength; i++) {
                    if(result[i]=='\0') break;
                    sb.append(result[i]);
                }
            }



            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void init(String input) {
        for(int start = 0; start<input.length(); start++) {
            Trie current = startingPoint;
            for(int i=start; i<input.length(); i++) {
                if(!current.child.containsKey(input.charAt(i))) {
                    current.child.put(input.charAt(i),new Trie());
                }
                if(i!=input.length()-1) {
                    current = current.child.get(input.charAt(i));
                    continue;
                }
                current.child.get(input.charAt(i))
                        .isEnd = true;
            }
        }
    }

    private static class Trie {

        boolean isEnd;
        HashMap<Character, Trie> child;

        Trie() {
            child = new HashMap<>();
        }
        private boolean dfs(int depth ,Trie trie) {
            if(trie.isEnd) {
                count++;
                if(count==K) {
                    resultLength = depth;
                    return true;
                }
            }

            for(int i=0; i<26; i++) {
                char ch =(char)('a'+ i);
                if(!trie.child.containsKey(ch)) {
                    continue;
                }
                result[depth] = ch;
                if(dfs(depth+1, trie.child.get(ch))) {
                    return true;
                }
            }

            return false;
        }
    }
}
