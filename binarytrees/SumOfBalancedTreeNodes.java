



class SumOfBalancedTreeNodes 
{

    class Node 
    {
        int data;
        Node left, right;

        Node(int item) 
        {
            data = item;
            left = right = null;
        }
    }
    int i = 1;
    Node sum(Node root, int l){
        if(l==0) return root;

        if(root==null ){
            if(l==1){
                root = new Node(i++);
            } else {
                root = new Node(0);
            }
        }

        root.left = sum(root.left, l-1);
        root.right = sum(root.right, l-1);

        root.data = root.left.data+root.right.data;
        return root;

    }

	/* This funtcion is here just to test buildTree() */
	void printInorder(Node node) 
	{
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
	public static void main(String args[]) 
	{
        SumOfBalancedTreeNodes nodes =  new SumOfBalancedTreeNodes();
        System.out.println("Inorder traversal of constructed tree is : ");
        
        Node root = nodes.sum(null, 3);

        System.out.println("root.data : " + root.data);
		
	}
}
