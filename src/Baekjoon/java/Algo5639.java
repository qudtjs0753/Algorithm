package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo5639 {
    private static class Tree {
        int root;
        Tree left, right;

        Tree(int root){
            this.root = root;
        }

        public void createTree(int child) {
            if(child<this.root){
                if(this.left==null)
                    this.left = new Tree(child);
                else
                    this.left.createTree(child);
            }else {
                if(this.right==null)
                    this.right = new Tree(child);
                else
                    this.right.createTree(child);
            }
        }
    }
    static StringBuilder sb = new StringBuilder();

    static Tree tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        tree = new Tree(Integer.parseInt(input));

        while(true){
            input = br.readLine();
            if(input==null || input.equals(""))break;
            tree.createTree(Integer.parseInt(input));
        }

        createPostOrder(tree);


        System.out.println(sb);
    }

    private static void createPostOrder(Tree root){
        if(root==null)return;

        createPostOrder(root.left);
        createPostOrder(root.right);
        sb.append(root.root).append("\n");
    }
}
