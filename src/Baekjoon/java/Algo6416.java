package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo6416 {

    static Set<String> set;
    static HashMap<String, Integer> node;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        boolean isTree = true;
        while(true){
            set = new HashSet<>();
            node = new HashMap<>();
            st = getInput();


            while(st.hasMoreTokens()){
                String v1 = st.nextToken();
                String v2 = st.nextToken();

                if(v1.equals("-1") && v2.equals("-1")){
                    System.out.print(sb);
                    return;
                } else if(v1.equals("0") && v2.equals("0"))break;

                if(!node.containsKey(v1)) node.put(v1,0);

                if(!node.containsKey(v2)) node.put(v2,1);
                else node.put(v2, node.get(v2) +1);

                set.add(v1);
                set.add(v2);
            }

            //노드 수와 간선 수 체크
            if(checkEdgeAndVertex() || set.size()==0){
                sb.append("Case " + count + " is a tree.\n");
            }else{
                sb.append("Case " + count + " is not a tree.\n");
            }
            count++;
        }
    }

    //input 받고 파싱.
    private static StringTokenizer getInput() throws IOException {
        StringBuilder input = new StringBuilder();
        StringTokenizer slicedInput;

        boolean haveMoreInput = true;
        while(haveMoreInput){
            slicedInput = new StringTokenizer(br.readLine());

            while(slicedInput.hasMoreTokens()){
                String str = slicedInput.nextToken();
                input.append(str).append(" ");
                if(str.equals("0") || str.equals("-1"))haveMoreInput=false;
            }
        }
        return new StringTokenizer(input.toString());
    }

    //vertex 수와 Edge 수 판별
    private static boolean checkEdgeAndVertex(){
        int countRoot = 0;
        for(String vertex : set){
            int edge = node.get(vertex);
            if(edge==0)countRoot++;
            else if(node.get(vertex)>1)return false;
        }

        if(countRoot==1)return true;
        return false;
    }
}
