//package

import java.util.Map;
import java.util.TreeMap;
import java.lang.Integer;
import java.util.List;
import java.util.ArrayList;

/**
 * PrintABinaryTreeVertically
 */
public class PrintABinaryTreeVertically {


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

    public void inOrderTraversal(Node root){
        if(root == null) return ;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        PrintABinaryTreeVertically tree = new PrintABinaryTreeVertically();

        Node root = tree.buildTree();

        //tree.inOrderTraversal(root);

        tree.printABinaryTreeVertically(root);
    }


    public void printABinaryTreeVertically(Node root){
        Map<Integer, List<Integer>> printMap = new TreeMap<>();
        printABinaryTreeVertically(root, printMap, 0);
        printMap(printMap);
    }

    public void printABinaryTreeVertically(Node root, Map<Integer, List<Integer>> printMap, int distanceFromRoot){

        if(root == null){
            return ;
        }
        List<Integer> values = printMap.get(distanceFromRoot);
        if(values == null){
            values = new ArrayList<Integer>();
            printMap.put(distanceFromRoot, values);            
        }
        values.add(root.data);

        printABinaryTreeVertically(root.left, printMap, distanceFromRoot-1);
        printABinaryTreeVertically(root.right, printMap, distanceFromRoot+1);
    }

    public void printMap(Map<Integer, List<Integer>> map){

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            List<Integer> values = entry.getValue();
            for(Integer value : values){
                System.out.print(value + " ");
            }
            System.out.println();
        }
        
    }
    
}