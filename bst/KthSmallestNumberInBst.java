


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
        smallest.getKthSmallestInBstUsingDfsRecursive(root, 3);

        smallest.usingBstTweakedDfsRecursive(root,3);

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
    public void getKthSmallestInBstUsingDfsRecursive(Node root, int k){

        if(root == null) return;
        getKthSmallestInBstUsingDfsRecursive(root.left, k);
        count++;
        if(count==k){
            System.out.println(k+" smallest number using getKthSmallestInBstUsingDfsRecursive : " + root.val);
            return;
        }
        if(count<k){
            getKthSmallestInBstUsingDfsRecursive(root.right, k);
        }
    }


    public int usingBstTweakedDfsRecursive(Node root, int k){
        int leftCount = this.countOfNodes(root.left);

        if(k<=leftCount){
            return usingBstTweakedDfsRecursive(root.left, k);
        } else if (k>leftCount+1){
            return usingBstTweakedDfsRecursive(root.right, k-leftCount-1);
        }

        System.out.println("kth smallest number using usingBstTweakedDfsRecursive : " + root.val);
        return root.val;
    }

    public int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return 1 + countOfNodes(root.left) + countOfNodes(root.right);
    }



    public int usingDfsIterative(Node root, int k){
        return 0;
    }
}