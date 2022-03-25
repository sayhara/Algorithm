package baekjoon.datastructure;

import java.util.*;
import java.io.*;

public class BJ_1991 {

    public static class Node {

        char data;
        Node left;
        Node right;

        public Node(char data){
            this.data=data;
        }
    }

    public static class Tree{

        Node root;

        public void addNode(char data, char left, char right){
            if(root==null){ // 아무것도 없는 초기상태
                root=new Node(data);

                if(left!='.'){
                    root.left=new Node(left);
                }
                if(right!='.'){
                    root.right=new Node(right);
                }
            } else {
                searchNode(root,data,left,right);
            }
        }

        public void searchNode(Node root, char data, char left, char right){
            if(root==null){
                return;
            } else if(root.data==data){
                if(left!='.'){
                    root.left=new Node(left);
                }
                if(right!='.'){
                    root.right=new Node(right);
                }
            } else {
                searchNode(root.left,data,left,right);
                searchNode(root.right,data,left,right);
            }
        }

        // 전위순회 : 루트 -> 좌 -> 우
        public void preOrder(Node root){
            System.out.print(root.data);
            if(root.left!=null) preOrder(root.left);
            if(root.right!=null) preOrder(root.right);
        }

        // 중위순위 : 좌 -> 루트 -> 우
        public void inOrder(Node root){
            if(root.left!=null) inOrder(root.left);
            System.out.print(root.data);
            if(root.right!=null) inOrder(root.right);
        }

        // 후위순위 : 좌 -> 우 -> 루트
        public void postOrder(Node root){
            if(root.left!=null) postOrder(root.left);
            if(root.right!=null) postOrder(root.right);
            System.out.print(root.data);
        }
    }

    // 전위 순회 (Root->Left->Right)
    public void preOrder(Node node){
        if(node!=null){
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 중위 순회 (Left->Root->Right)
    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    // 후위 순회(Left->Right->Root)
    public void postOrder(Node node){
        if(node!=null){
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        Tree tree=new Tree();

        for(int i=0;i<N;i++){
            char[] data;
            data=br.readLine().replace(" ","").toCharArray();
            tree.addNode(data[0],data[1],data[2]);
        }

        tree.preOrder(tree.root);
        System.out.println();

        tree.inOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
        System.out.println();

    }
}
