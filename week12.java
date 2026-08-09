import java.util.ArrayList;
import java.util.List;
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

    ///////////////// Combination Sum III \\\\\\\\\\\\\\\\

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        //List<Integer> sum = new ArrayList<>();

        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private static void solve(int start, int k, int target, List<Integer> sum, List<List<Integer>>ans){
        if(sum.size() == k){
            if(target == 0){
                ans.add(new ArrayList(sum));
            }
            return;    
        }

        for(int i = start; i <= 9; i++){
            sum.add(i);
            solve(i + 1, k, target - i, sum, ans);
            sum.remove(sum.size() - 1);
        }
    }



    public static void main(String[] args) {
       int nums[] = {3,2,1,5,6,4};
       int k = 2;
       System.out.println(findKthLargest(nums, k));

       int k1 = 3, n = 7;
       List<List<Integer>> ans = combinationSum3(k1, n);
       System.out.println(ans);
    }
}
