//package ctci.tests;

import java.lang.Integer;

/**
 * This Program will find the next successor node in a Binary Search Tree given a search node. All nodes in the tree will have mapping to parent as well
 */
public class C4_6_NextSuccessorNode{


    public class Node{
        private int data;

        private Node left, right, parent;

        public Node(int data, Node parent){
            this.data = data;
            this.parent = parent;
        }

    }


    public static void main(String... args){

        C4_6_NextSuccessorNode nsc = new C4_6_NextSuccessorNode();
        nsc.getNextSuccessor();
    }

    public void getNextSuccessor(){
        Integer min = Integer.MAX_VALUE;
        Node node20 = new Node(20, null);

        Node node8 = new Node(8, node20);
        Node node22 = new Node(22, node20);
        node20.left=node8;
        node20.right=node22;

        Node node4 = new Node(4, node8);
        Node node12 = new Node(12, node8);
        node8.left=node4;
        node8.right=node12;
        
        Node node10 = new Node(10, node12);
        Node node14 = new Node(14, node12);
        node12.left=node10;
        node12.right=node14;

        System.out.println(nextSuccessor(node20));
        System.out.println(nextSuccessor(node8));
        System.out.println(nextSuccessor(node22));
        System.out.println(nextSuccessor(node4));
        System.out.println(nextSuccessor(node12));
        System.out.println(nextSuccessor(node10));
        System.out.println(nextSuccessor(node14));

        System.out.println();

        /*System.out.println(nextSearch(node20, 20, min));
        System.out.println(nextSearch(node20, 8, min));
        System.out.println(nextSearch(node20, 22, min));
        System.out.println(nextSearch(node20, 4, min));
        System.out.println(nextSearch(node20, 12, min));
        System.out.println(nextSearch(node20, 10, min));
        System.out.println(nextSearch(node20, 14, min));*/


    }



    public int nextSuccessor(Node search){

        Node next = null;
        Node n = search;
        if(n.right!=null){
            n = n.right;
            next = n;
            while(n.left!=null){
                n=n.left;
                next = n;
            }
        }

        if(next == null){
            n = n.parent;
            while(n!=null && n.data<search.data){
                next = n;
                n = n.parent;
            }
            if(n==null || n.data<search.data){
                return -1;
            }
            next = n;
        }
        return next.data;
    }

    /*public int nextSearch(Node root, int search, int min){
        if(root == null){
            return null;
        }

        if(root.data == search) return min;
        int new_min = min;
        if(root.data>search){
            int new_min = root.data<min?root.data:min;
        }

        if(!search(root.left, search, new_min)){
            search(root.right, search, new_min);
        }
        return new_min;
    }*/

}