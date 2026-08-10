import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    //////////////// Check The Array Contains Dublicates \\\\\\\\\\\\\\\\\\

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    ///////////////////// Check The Array Contains Dublicates \\\\\\\\\\\\\

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int prev = map.get(nums[i]);

                if(i - prev <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }



    public static void main(String[] args) {
       int nums[] = {3,2,1,5,6,4};
       int k = 2;
       System.out.println(findKthLargest(nums, k));

       int k1 = 3, n = 7;
       List<List<Integer>> ans = combinationSum3(k1, n);
       System.out.println(ans);

       int arr[] = {1,1,1,3,3,4,3,2,4,2};
       System.out.println(containsDuplicate(arr));

       int arr1[] =  {1,2,3,1};
       int k2 = 3;
       System.out.println(containsNearbyDuplicate(arr1, k2));
    }
}
