


/**
 * KthSmallestNumberInBst
 */
public class KthSmallestNumberInBst {

    
    public class Node{

        Node left, right = null;
        int val;

        public Node(int val){
            this.val = val;
        }

        public String toString(){
            return ""+val;
        }
    }


    private int count;

    public static void main(String[] args) {
        
    	KthSmallestNumberInBst smallest = new KthSmallestNumberInBst();
        Node root = smallest.buildBST();
        System.out.print("Printing... ");
        smallest.printInOrder(root);
        System.out.println();
        smallest.count=0;
        smallest.getKthSmallestUsingBst(root, 3);

    }

    public Node buildBST(){
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(11);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(13);
        return root;
    }

    public void printInOrder(Node root){

        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    /**
     * Using BST
     */
    public void getKthSmallestUsingBst(Node root, int k){

        if(root == null) return;

        getKthSmallestUsingBst(root.left, k);
        count++;

        if(count==k){
            System.out.println(k+" smallest number : " + root.val);
            return;
        }

        if(count<k){
            getKthSmallestUsingBst(root.right, k);
        }

    }
}