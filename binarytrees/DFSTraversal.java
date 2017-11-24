//package 


/**
 * DFSTraversal
 */
public class DFSTraversal {


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

        node4.left=node2;
        node4.right=node6;
        
        node2.left=node1;
        node2.right=node3;

        node6.left=node5;
        node6.right=node7;

        return node4;
        
    }

    public static void main(String...args){
        
        //DFS can be implemented in three ways. Look at inOrder, preOrder, postOrder traversal

    }

    
}