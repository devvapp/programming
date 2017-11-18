//package ctci.tests;

import java.lang.Integer;

public class C4_5_ValidateBST{

    public class Node{
        private int data;
        //private boolean visited;
        private Node left;
        private Node right;
        
        public Node(int data){
            this.data = data;
        }

    }

    public static void main(String[] args){
        C4_5_ValidateBST bst = new C4_5_ValidateBST();
        bst.checkBST();
    }

    public void checkBST(){
        Node node10 = new Node(10);
        Node node6 = new Node(6);
        Node node4 = new Node(4);
        Node node8 = new Node(8);
        Node node18 = new Node(18);
        Node node15 = new Node(15);
        Node node21 = new Node(21);

        node10.left=node6;
        node10.right=node18;
        
        node6.left=node4;
        node6.right=node8;

        node18.left=node15;
        node18.right=node21;

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        System.out.println(checkBST(node10, min, max));
    }

    public boolean checkBST(Node root, int min, int max){
        if(root != null){ 
            System.out.println("root.data - " + root.data + ", min - " + min + ", max - " + max);
            if(root.data>max || root.data< min){
                return false;
            }
            return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
        }  
        return true;
    }


}