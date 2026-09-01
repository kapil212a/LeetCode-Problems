public class LL3 {
    public static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
        
    }
    
    ///////////////// Delete Node in a Linked List \\\\\\\\\\\\
    
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        ListNode node = new ListNode(5);
        deleteNode(node);

        
    }
}
