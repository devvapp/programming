//package

/**
 * DeleteALeafNode
 */
public class DeleteALeafNode {

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
        DeleteALeafNode deleteALeafNode = new DeleteALeafNode();
        Node root = deleteALeafNode.buildTree();
        System.out.print("Before - ");
        deleteALeafNode.inOrderTraversal(root);
        deleteALeafNode.deleteALeafNode(root, 8);
        System.out.print("\nAfter - ");
        deleteALeafNode.inOrderTraversal(root);
        System.out.println();
    }


    public void inOrderTraversal(Node root){
        if(root == null) return ;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public boolean deleteALeafNode(Node root, int sv){

        if(root == null){
            return false;
        }

        if(root.data == sv && root.left == null && root.right == null){
            return true;
        }

        if(deleteALeafNode(root.left, sv)){
            root.left = null;
        }
        if(deleteALeafNode(root.right, sv)){
            root.right = null;
        }
        return false;
    }

}