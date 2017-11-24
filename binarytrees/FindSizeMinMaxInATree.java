//pacakage


/**
 * FindSizeMinMaxInATree
 */
public class FindSizeMinMaxInATree {
    
    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public Node buildTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        node5.left = node8;
        node1.right = node9;

        return node4;

    }

    public static void main(String... args) {

        FindSizeMinMaxInATree traversal = new FindSizeMinMaxInATree();
        Node root = traversal.buildTree();
        System.out.print("min - " + traversal.min(root));
        System.out.print("max - " + traversal.max(root, Integer.MIN_VALUE));
        System.out.print("size - " + traversal.size(root));
    }

    public int min(Node root) {
        int min = root.data;
        if(root.left!=null){
            min = Math.min(min, min(root.left));
        }
        if(root.right!=null){
        min = Math.min(min, min(root.right));
        }

        return min;

    }

    public int max(Node root, int max) {
        if (root == null)
            return max;

        max = max(root.left, max);
        max = max(root.right, max);
        
        if (root.data > max) {
            max = root.data;
        }

        return max;

    }

    public int size(Node root) {
        if (root == null)
            return 0;
        return size(root.left) + 1 + size(root.right);
    }
}