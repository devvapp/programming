/**
 * ReverseLinkedList
 */
public class ReverseLinkedList {

    static Node head;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Function to reverse the linked list */
    public Node reverse(Node node) {
       
        if(node==null){
            return null;
        }
        Node prev=null;
        Node curr = node;
        Node next = node.next;

        while(next!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
        }

        curr.next=prev;
        return curr;
    }
 
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
         
        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}