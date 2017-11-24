//package

import java.lang.Integer;


/**
 * BinarySearchTree
 */
public class BinarySearchTree {


    public class Node{
        private int data;
        private Node left, right;

        public Node(int data){
            this.data = data;
        }

        public String toString(){
            return "" + data;
        }
    }

    public void inOrderTraversal(Node root){
        if(root == null) return ;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        //Build a binary search tree
        //Node root = bst.buildTree();
        Node node = bst.insert(null, 4);
        bst.insert(node, 2);
        bst.insert(node, 6);
        bst.insert(node, 1);
        bst.insert(node, 3);
        bst.insert(node, 9);
        bst.insert(node, 5);
        bst.insert(node, 7);
        bst.insert(node, 8);

        //In order traversal of a bst
        bst.inOrderTraversal(node);
        System.out.println();

        //Search for a node
        System.out.println("8 - " + bst.searchReturnWithABoolean(node, 8));

        System.out.println("7 - " + bst.searchNode(node, 7));
        System.out.println("13 - " + bst.searchNode(node, 13));
        System.out.println("3 - " + bst.searchNode(node, 3));
        System.out.println();


        //DELETE
        //bst.delete(node, 2);
        //bst.inOrderTraversal(node);
        //System.out.println();
        

        //CHECK IF THE TREE IS A BST
        System.out.println("Is the tree a BST - " + bst.isBST(node));


        //Successor of a value
        System.out.println("Successor of 8 - "  + bst.successorIterative(node, 8));
        System.out.println("Successor of 1 - "  + bst.successorIterative(node, 1));
        System.out.println("Successor of 4 - "  + bst.successorIterative(node, 4));
        System.out.println("Successor of 9 - "  + bst.successorIterative(node, 9));


        //ksmallest node
        bst.kSmallest(node, 3, 0);

    }

    /**
     * Insert a node into the tree
     */
    public Node insert(Node root, int data){
        
        if(root == null){
            return new Node(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        } else if(data > root.data){
            root.right = insert(root.right, data);
        }

        return root;
    }

    /**
     * Return true or false 
     */
    public boolean searchReturnWithABoolean(Node root, int sv){
        if(root == null ){
            return false;
        }
        if(root.data == sv){
            return true;
        }
        return searchReturnWithABoolean(root.left, sv) || searchReturnWithABoolean(root.right, sv);
    }

    /**
     * Return search node recursively
     */
    public Node searchNode(Node root, int sv){
        if(root == null || root.data == sv){
            return root;
        }
        Node searchNode = searchNode(root.left, sv);
        if(searchNode ==null){
            searchNode = searchNode(root.right, sv);
        }
        return searchNode;
    }

    /**
     * Return search node iteratively
     */
    public Node searchNodeIterative(Node root, int sv){
        Node searchNode = null;
        while(root != null){
            if(sv <root.data){
                root = root.left;
            } else if ( sv > root.data){
                root = root.right;
            } else {
                searchNode = root;
                break;
            }
        }
        return searchNode;
    }

    public void deleteKey(Node root, int key){

        //BASE CASE
        if(root == null){
            return root;
        }

        if(key < root.data){
            root.left = deleteKey(root.left, key);
        } else  if (key>root.data){
            root.right = deleteKey(root.right, key);
        } else {

            //Found the key?

            //If only one child 
            if(root.right == null){
                return root.left;
            } else if (root.left == null){
                return root.right;
            }

            //Now Replace root data with the min value of right true
            //And delete that min
            Node minNode = min(root.right);
            root.data=minNode.data;

            root.right = deleteKey(root.right, root.data);
        }

        return root;
    }

    //Check to see if a tree is a BST
    public boolean isBST(Node root){

        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(Node root, int min, int max){

        if(root == null) return true;

        if(root.data < min && root.data > max){
            return false;
        }

        return isBST(root.left, min, root.data-1) || isBST(root.right, root.data+1, max);

    }


    /**
     * Search successor recursively.
     * Not working, need to fix it
     */
    public Node successor(Node root, int sv, boolean found){
        if(root == null){
            return root;
        }

        Node searchNode = successor(root.left, sv, found);
        if(searchNode != null){
            if(found){
                return root;
            }
            if(!found && root.data == sv){
                found = true;
            }
    
            searchNode = successor(root.right, sv, found);
        }

        return searchNode;

    }

    /**
     * Search successor iteratively
     */
    public Node successorIterative(Node root, int sv){
        if(root == null ) return root;

        Node searchNode = searchNodeIterative(root, sv);
        return successorIterative(root, searchNode);
    }

    public Node successorIterative(Node root, Node searchNode){
    	
    	if(root == null || searchNode == null){
    		return null;
    	}
        
        // Step 1 = If search node has right value then the minimum of right is the next successor.
        if(searchNode.right != null){
            return min(searchNode.right);
        }

        // Step2 = Else right the parent from root
        Node succ = null;
        //Node prev = null;
        while(root != null){
            
            if(searchNode.data < root.data){
                succ = root;
                //prev = root;
                root = root.left;
            } else if (searchNode.data > root.data){
                //prev = root;
                root = root.right;
            } else {
                break;
            }
        }

    	return succ;
    }

    public Node min(Node root){
        if(root == null) return root;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public Node max(Node root){
        if(root == null) return root;
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    public void kSmallest(Node root, int sv, int count){

        if(root == null) return ;

        kSmallest(root.left, sv, count);
        count++;
        if(count == sv){
            System.out.println(root.data);
            return;
            //return root.data;
        }
        if(count < sv){
            kSmallest(root.right, sv, count);
        }
    }

}