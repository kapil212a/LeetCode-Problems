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

    //////////////////////// Insertion Sort in List \\\\\\\\\\\\\\\\\\\\\\\\

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

    ///////////////////// merge Sort in List \\\\\\\\\\\\\\\\\\\\\\\

    public static ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(midNext);

        return merge(left , right);
    }
    
    public static ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(a != null && b != null){
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            }
            else{
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if(a != null){
            curr.next = a;
            
        }
        if(b != null){
            curr.next = b;
            
        }
        return dummy.next;
    }

    public static ListNode findMid(ListNode head){
        ListNode fast = head.next , slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ///////////////////// InterSection Of 2 LinkedList \\\\\\\\\\\\\\\

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            if(a == null){
                a = headB;
            }else{
                a = a.next;
            }

            if(b == null){
                b = headA;
            }
            else{
                b = b.next;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(1);
        //System.out.println(hasCycle(head));

        ListNode head1 = new ListNode(-1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(0); 
        //insertion(head1);
        //printll(head1);

       
        printll(sortList(head1));
        printll(head1);

    }
}
