//package

import java.util.Stack;

/**
 * InOrderTraversalWithoutRecursion
 */
public class InOrderTraversalWithoutRecursion {

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


    
    public static void main(String[] args) {
        InOrderTraversalWithoutRecursion inOrderTraversalWithoutRecursion = new InOrderTraversalWithoutRecursion();

        Node root = inOrderTraversalWithoutRecursion.buildTree();
        inOrderTraversalWithoutRecursion.inOrderTraversalWithoutRecursion(root);

    }

    public void inOrderTraversalWithoutRecursion(Node root){
        
        if(root == null){
            return ;
        }
        Node node = root;

        Stack<Node> stack = new Stack<Node>();

        while(node!=null){
            stack.push(node);
            node = node.left;
        }

        while(stack.size()>0){
            node = stack.pop();
            System.out.print(node.data + " ");
            if(node.right != null){
                node = node.right;
                
                while(node!=null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public void inOrderTraversalWithoutRecursionAndStack(Node root){


    }

}