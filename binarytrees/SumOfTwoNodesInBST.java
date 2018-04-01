// Java code to find a pair with given sum 
// in a Balanced BST
import java.util.ArrayList;

class SumOfTwoNodesInBST
{
    
    class Node {
	
        int data;
        Node left, right;
        
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    	// Root of BST
	Node root;

	// Constructor
	SumOfTwoNodesInBST() { 
		root = null; 
	}
	
	public void sum(Node lroot, Node rroot, int sum){
	   
	   if(lroot==null || rroot==null){
	       return;
	   }
	   
	   sum(lroot.left, rroot, sum);
	   sum(lroot, rroot.right, sum);
	   
	   int nodeSum = lroot.data+rroot.data;
	   
	   if(nodeSum == sum){
	       System.out.println("Found - " + lroot.data + " + " + rroot.data + " = " + sum);
	       return;
	   }
	   
	   if(nodeSum>sum){
	        sum(lroot, rroot.left, sum);
	   } else if(nodeSum < sum){
	        sum(lroot.right, rroot, sum);
	   }
	   return;
	}
    
    // This method mainly calls insertRec()
	void insert(int key) {
        root = insertRec(root, key);
    }
    
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int data) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(data);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

	// Driver function
	public static void main(String[] args) {
		SumOfTwoNodesInBST tree = new SumOfTwoNodesInBST();
		/*
			   15
			 /	 \
			10	 20
			/ \	 / \
		   8 12 16 25 */
		tree.insert(15);
		tree.insert(10);
		tree.insert(20);
		tree.insert(8);
		tree.insert(12);
		tree.insert(16);
		tree.insert(25);
		
		tree.sum(tree.root, tree.root , 20);
		}
}

// This code is contributed by Kamal Rawal
