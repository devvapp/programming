//package trees.tests;


/**
 * InPrePostOrderTreeTraversal
 */
public class InPrePostOrderTreeTraversal {

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

        InPrePostOrderTreeTraversal traversal = new InPrePostOrderTreeTraversal();

        Node root = traversal.buildTree();

        System.out.print("InOrder - ");
        traversal.inOrderTraversal(root);
        System.out.print("\nPreOrder - ");
        traversal.preOrderTraversal(root);
        System.out.print("\nPostOrder - ");
        traversal.postOrderTraversal(root);
        System.out.println();
    }


    public void inOrderTraversal(Node root){
        if(root == null) return ;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(Node root){
        if(root == null) return ;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root){
        if(root == null) return ;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }


}