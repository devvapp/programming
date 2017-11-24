//package trees.tests;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFSTraversal Or Level Order Traversal for Binary Tree. Can also generalize for other trees
 */
public class BFSTraversal {

    public class Node{
        private int data;
        private Node left;
        private Node right;
        
        public Node(int data){
            this.data = data;
        }

    }
    
    public Node buildTree(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node4.left=node2;
        node4.right=node6;
        
        node2.left=node1;
        node2.right=node3;

        node6.left=node5;
        node6.right=node7;

        node5.left=node8;
        node1.right=node9;

        return node4;
        
    }

    public static void main(String...args){
        
        BFSTraversal traversal = new BFSTraversal();
        Node root = traversal.buildTree();
        System.out.print("bfsTraversalForBinaryTree - ");
        traversal.bfsTraversalForBinaryTree(root);
        System.out.print("bfsTraversalForBinaryTreeUsingRecursion - ");
        traversal.bfsTraversalForBinaryTreeUsingRecursion(root);
    }
    
    /** 
     * This method traverses one row at a time. 
     * This uses queue to maintain the elements of the row. 
     * Can generalize and traverse any tree not just binary tree
     * 
     * Time complexity - O(n), Extra Space Complexity - O(w), where w is the max width of the tree.
     * So max width of the queue is w.
     * max width = 2 power h, where h is the height of the tree;
     */
    public void bfsTraversalForBinaryTree(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.peek()!=null){
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        System.out.println();
    }


    /**
     * This method will traverse through the tree using height of the tree and printing all the nodes at the same level. 
     * It also uses recursion.
     * 
     * Time complexity - O(n^2), Extra Space Complexity - Stack will be used internally for recursion calls.
     * So max width of the queue is w.
     * max width = 2 power h, where h is the height of the tree;
     * 
     */
    public void bfsTraversalForBinaryTreeUsingRecursion(Node root){
        int height = getHeight(root);
        for(int i = 0; i<height; i++){
            bfsTraversalForBinaryTreeUsingRecursion(root, i);
        }
        System.out.println();
    }

    public void bfsTraversalForBinaryTreeUsingRecursion(Node root, int level){
        if(root == null) return ;
        if(level == 0){
            System.out.print(root.data + " ");
        } else{
            bfsTraversalForBinaryTreeUsingRecursion(root.left, level-1);
            bfsTraversalForBinaryTreeUsingRecursion(root.right, level-1);
        }
    }

    /**
     * Get the height of the tree
     */
    public int getHeight(Node root){
        return getHeight(root, 0);
    }

    public int getHeight(Node root, int height){
        if(root == null) return height;
        int leftheight = getHeight(root.left, height+1);
        int rightheight = getHeight(root.right, height+1);
        if(leftheight>rightheight) return leftheight;
        return rightheight;
    }


}