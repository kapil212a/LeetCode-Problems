import java.util.PriorityQueue;

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

    ///// Merge Two Sorted List \\\\\\\\


    public static Node mergeTwoLists(Node list1, Node list2) {
        Node dm = new Node(-1);

        Node curr = dm;

        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null){
            curr.next = list1;
        }
        if(list2 != null){
            curr.next = list2;
        }
        return dm.next;
    }

    ////// Merge K Sorted List \\\\
 
    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);

        for(Node node : lists){
            if(node != null){
                pq.offer(node);
            }
        }
        Node dm = new Node(-1);
        Node curr = dm;

        while(!pq.isEmpty()){
            Node small = pq.poll();

            curr.next = small;
            curr = curr.next;

            if(small.next != null){
                pq.offer(small.next);
            }
        }
        return dm.next;
    }

    ///// Swip Node In pair \\\\\\

    public static Node swapPairs(Node head) {
        Node dm = new Node(0);
        dm.next = head;

        Node prev = dm;

        while(head != null && head.next != null){
            Node first = head;
            Node second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }
        return dm.next;
    }
 //////// REVERSE NODE IN K GROUP \\\\\\\\ 
 
    public  static Node reverseKGroup(Node head, int k) {
        Node temp = head;

        for(int i = 0; i<k; i++){
            if(temp == null){
                return head;
            }
            temp = temp.next;
        }

        Node prev = null , curr = head,  next = null;
        int count = 0;

        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            count++;

        }
        head.next = reverseKGroup(curr , k);
        return prev;
    }

///////// ROTATE THE LIST FROM K \\\\\\\\\\\\

    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = 1; 
        Node temp = head;

        while(temp.next != null){            ////// FINDING LAST ELEMENT AND LENTH OF LIST
            temp = temp.next;
            len++;
        }

        k = k % len;
        if(k == 0){
            return head;
        }

        temp.next = head;                   /////// MAKING CIRCULAR LIST
        int step = len - k - 1;             /////// FIND THE STEP FROM WE ROTATE THE LIST
        Node tail = head;

        for(int i = 0; i < step; i++){      /////// REACHING THE ROTATEING PLACE
            tail = tail.next;
        }

        Node newHead = tail.next;           /////// INITIALIZE THE HEAD TO THE NEW NODE 
        tail.next = null;                    ///// BREAKING THE CIRCULAR LIST
        return newHead; 
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

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        
        printLL(mergeTwoLists(head1 , head2));

        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node l3 = new Node(2);
        l3.next = new Node(6);

        Node[] lists = { l1, l2, l3 };
        
        printLL(mergeKLists(lists));

        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        printLL(head3);
        swapPairs(head3);
        printLL(head3);

        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(3);
        head4.next.next.next = new Node(4);
        head4.next.next.next.next = new Node(5);
        printLL(head4);
        int n1 = 3;
        reverseKGroup(head4, n1);
        printLL(head4);


        Node head5 = new Node(1);
        head5.next = new Node(2);
        head5.next.next = new Node(3);
        head5.next.next.next = new Node(4);
        head5.next.next.next.next = new Node(5);
        int k = 3;
        printLL(head5);
        rotateRight(head5, k);
        printLL(head5);
    }

}
