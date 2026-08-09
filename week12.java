import java.util.PriorityQueue;

public class week12 {
    /////////////// Kth Largest Element in an Array \\\\\\\\\\\\\\

    public static int findKthLargest(int[] nums, int k) {
       PriorityQueue <Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }

        }
        return pq.peek();


    }


    public static void main(String[] args) {
       int nums[] = {3,2,1,5,6,4};
       int k = 2;
       System.out.println(findKthLargest(nums, k));
    }
}
