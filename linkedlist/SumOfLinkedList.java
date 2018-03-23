/**
 * ReverseLinkedList
 */
public class SumOfLinkedList {

    static Node head1;
    static Node head2;

    static Node result;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Function to sum the linked list */
    public void sumInForwardDirection(Node ptr1, Node ptr2) {
       int carry = 0;
       int total = 0;
       Node rptr = null;
       
       while(ptr1!=null || ptr2!=null){
            int sum = (ptr1!=null?ptr1.data:0)+(ptr2!=null?ptr2.data:0);
            total = (total*10)+sum;
            carry = sum/10;
            int val = sum%10;
            if(result == null){
                if(carry>0){
                    rptr = result = new Node(carry);
                    rptr.next = new Node(val);
                    rptr = rptr.next;
                } else {
                    rptr = result = new Node(val);
                }
            } else { 
                rptr.data+=carry;
                rptr.next=new Node(val);
                rptr = rptr.next;
            }

            ptr1=ptr1.next;
            ptr2=ptr2.next;
       }

       System.out.println("total : " + total);

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
        SumOfLinkedList list = new SumOfLinkedList();
        list.head1 = new Node(5);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(3);

        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        list.head2.next.next = new Node(2);
        
         
        System.out.println("List1 : ");
        list.printList(head1);
        System.out.println("List2 : ");
        list.printList(head2);
        
        list.sumInForwardDirection(head1, head2);
       
        System.out.println("Sum of linked list in forward direction : ");
        list.printList(result);
    }
}