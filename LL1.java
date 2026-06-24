public class LL1 {
    public static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
        }

    }
    //////////////// Print Linked List \\\\\\\\\\\\\\\\\\\\\\\\\
    
    public static void printLL(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }System.out.println("null");
    }

    //////////////// Remove all element which are Dublicates from List II \\\\\\\\\\\\\\\\ 

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy  = new ListNode(0);
        dummy.next  = head;

        ListNode curr = head;
        ListNode prev = dummy;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                int value = curr.val;

                while(curr != null && curr.val == value){
                    curr = curr.next;
                }
                prev.next = curr;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    ////////////// Remove Duplicates From Sorted List \\\\\\\\\\\\\\\\\\\
    
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode curr = head;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }

    ////////////////////// Partition The element are less Then x In \\\\\\\\\\\\\\\\\

    public static ListNode partition(ListNode head, int x) {
        ListNode smallNew = new ListNode(0);
        ListNode largeNew = new ListNode(0);

        ListNode small = smallNew;
        ListNode large = largeNew;

        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }
            else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeNew.next;

        return smallNew.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        printLL(head);
        deleteDuplicates(head);
        printLL(head);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next = new ListNode(4);
        printLL(head1);
        deleteDuplicates1(head1);
        printLL(head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(2);
        int x = 3;
        printLL(head2);
        partition(head2, x);
        printLL(head2);



    }
}
