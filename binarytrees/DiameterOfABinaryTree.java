//package

import java.lang.Integer;
import java.util.List;
import java.util.ArrayList;

/**
 * DiameterOfABinaryTree
 */
public class DiameterOfABinaryTree {


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
        
        DiameterOfABinaryTree diameterOfABinaryTree = new DiameterOfABinaryTree();
        Node root = diameterOfABinaryTree.buildTree();

        System.out.println(diameterOfABinaryTree.diameterOfABinaryTree(root));

    }


    //Incomplete
    public int diameterOfABinaryTree(Node root){
        List<Integer> path = new ArrayList<Integer>();
        return getDiameter(root, 0, path, 0);
    }

    //Incomplete, didnt work
    public int getDiameter(Node root, int height, List<Integer> path, int diameter){
        if(root == null) return height;
        path.add(root.data);
        int leftheight = getDiameter(root.left, height+1, path, diameter);
        int rightheight = getDiameter(root.right, height+1, path, diameter);
        
        int totalheight = leftheight+rightheight-1;
        return totalheight>diameter?totalheight:diameter;
    }

    
}