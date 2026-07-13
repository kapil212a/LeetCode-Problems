import javax.swing.tree.TreeNode;

public class LL2 {
    public static class ListNode{
        ListNode next;
        int val;

        public  ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void printll(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }System.out.println("null");
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

    //////////////////////// Insertion Sort in Tree \\\\\\\\\\\\\\\\\\\\\\\\

    public static ListNode insertion(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            ListNode prev = dummy;

            while(prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
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
        System.out.println(hasCycle(head));

        ListNode head1 = new ListNode(-1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(0); 
        insertion(head1);
        printll(head1);

    }
}
