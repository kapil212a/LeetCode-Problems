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

    //////////////// Remove Dublicates from List II \\\\\\\\\\\\\\\\ 

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
    }
}
