//package


/**
 * AncestorsOfANode
 */
public class AncestorsOfANode {

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
        AncestorsOfANode ancestorsOfANode = new AncestorsOfANode();
        Node root = ancestorsOfANode.buildTree();
        ancestorsOfANode.ancestorsOfANode(root, 8);
        System.out.println();
    }

    public int ancestorsOfANode(Node root, int sv){

        if(root == null){
            return 0;
        }
       
        if(sv==root.data){
            return -1;
        }
        int result = ancestorsOfANode(root.left, sv);
        if(result != -1) {
            result = ancestorsOfANode(root.right, sv);  
        }
        if(result == -1) {
            System.out.print(root.data + " ");
            return -1;
        }
        return 0;
    }
}