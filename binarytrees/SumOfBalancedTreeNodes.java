/**
 * This class will build a balanced binary tree and also tell sum of all nodes at the specified level
 */
class SumOfBalancedTreeNodes {

    class Node {
        int data;
        int sumAtThisNode;
        Node left, right;

        Node(int item) {
            data = item;
            sumAtThisNode = 0;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", sumAtThisNode=" + sumAtThisNode + ", left=" + left + ", right=" + right
                    + "]";
        }

    }
    int i = 1;
    Node sum(Node root, int l) {
        if (l == 0)
            return root;

        if (root == null) {
            if (l == 1) {
                root = new Node(i++);
                root.sumAtThisNode=root.data;
            } else {
                root = new Node(0);
            }
        }

        root.left = sum(root.left, l - 1);
        root.right = sum(root.right, l - 1);
        if (root.left != null && root.right != null) {
            root.data = root.left.data + root.right.data;
            root.sumAtThisNode = root.data + root.left.sumAtThisNode + root.right.sumAtThisNode;
        }
        return root;

    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    // driver program to test above functions
    public static void main(String args[]) {
        SumOfBalancedTreeNodes nodes = new SumOfBalancedTreeNodes();
        System.out.println("Inorder traversal of constructed tree is : ");

        Node root = nodes.sum(null, 5);

        nodes.printInorder(root);

        System.out.println("\nroot.data : " + root.data);
        System.out.println("root.sumAtThisNode : " + root.sumAtThisNode);

    }
}
