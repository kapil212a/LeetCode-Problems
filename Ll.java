
public class Ll {

    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        
    }

    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    //// Remove nth node from The Last Of LinkedList /////
    public static Node head;
    public static Node tail;
    
    public static Node removeNthFromEnd(Node head, int n) {
        int length = 0;
        Node temp = head;
        
        while(temp != null){
            length++;
            temp = temp.next;
        }
        if(length == n){
            return head.next;
        }
        temp = head;
        for(int i = 1; i < length - n; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        printLL(head);

        int n = 2;
        removeNthFromEnd(head , n);
        printLL(head);
    }

}
