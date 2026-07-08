public class LL2 {
    public static class ListNode{
        ListNode next;
        int data;

        public  ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    ////////////////// Detect Cycle in LinkedList\\\\\\\\\\\\\\\\
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        } 
        return false;
    } 


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        System.out.println(hasCycle(head));
    }
}
