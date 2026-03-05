package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1991 {
    static int N;
    static class Node {
        String root;
        Node leftChild = null, rightChild=null;
        Node(){
        }
        Node(String root){
            this.root = root;
        }

    }

    public static void addNode(Node node, String rootValue, String leftValue, String rightValue){
        Node toAdd = findNode(rootValue, node);

        if(toAdd==null){
            toAdd = node;
            toAdd.root = rootValue;
        }
        if(!leftValue.equals("."))toAdd.leftChild = new Node(leftValue);
        if(!rightValue.equals("."))toAdd.rightChild = new Node(rightValue);
    }
    public static Node findNode(String value, Node node){
        Node left, right;
        if(node==null || node.root==null)return null;

        //자식노드 찾았을 때.
        if(node.root.equals(value)) return node;

        //왼쪽오른쪽 각각 탐색.
        if((left = findNode(value, node.leftChild))!=null) return left;
        else if((right = findNode(value, node.rightChild))!=null) return right;

        return null;
    }
    public static void printPreOrder(Node root){
        if(root!=null){
            System.out.print(root.root);
            printPreOrder(root.leftChild);
            printPreOrder(root.rightChild);
        }
    }
    public static void printInOrder(Node root){
        if(root!=null){
            printInOrder(root.leftChild);
            System.out.print(root.root);
            printInOrder(root.rightChild);
        }
    }
    public static void printPostOrder(Node root){
        if(root!=null){
            printPostOrder(root.leftChild);
            printPostOrder(root.rightChild);
            System.out.print(root.root);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Node root = new Node();
        while(N>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            addNode(root, st.nextToken(),st.nextToken(),st.nextToken());
            N--;
        }
        printPreOrder(root);
        System.out.println();
        printInOrder(root);
        System.out.println();
        printPostOrder(root);
    }
}

