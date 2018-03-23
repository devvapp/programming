/**
 * SplitAlternativeLinkedList
 */
public class SplitAlternativeLinkedList {

    static Node head;
    static Node headOdd;
    static Node headEven;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
        /* Function to split the linked list */
        public void splitAlternativeLinkedList(Node node) {
       
            if(node==null){
                return;
            }
            headOdd = node;
            if(headOdd.next==null){
                return;
            }
            headEven = headOdd.next;
    
            Node ptrOdd = headOdd;
            Node ptrEven = headEven;
    
            while(ptrOdd !=null && ptrEven != null){
                Node next = ptrEven.next;
                ptrOdd.next=next;
                ptrOdd = next;
                if(next!=null){
                    ptrEven.next = next.next;
                    ptrEven = next.next;
                }
            }
            
        }
     
        // prints content of double linked list
        void printList(Node node) {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }
 
    public static void main(String[] args) {
        SplitAlternativeLinkedList list = new SplitAlternativeLinkedList();
        list.head = new Node(0);
        list.head.next = new Node(1);
        list.head.next.next = new Node(0);
        list.head.next.next.next = new Node(1);
        list.head.next.next.next.next = new Node(0);
        list.head.next.next.next.next.next = new Node(1);
         
        System.out.println("Given Linked list");
        list.printList(head);
        list.splitAlternativeLinkedList(head);
        System.out.println("Split linked list ");
        list.printList(headOdd);
        list.printList(headEven);
    }
    
}