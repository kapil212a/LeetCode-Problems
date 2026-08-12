import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class week12 {
    public static void printarr(int arr[]){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + " ");
        }System.out.println("]");
    }
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

   //////////// Overlapping Rectangular Area \\\\\\\\\\\\\\\\

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int width = Math.min(ax2,bx2) - Math.max(ax1, bx1);
        int height = Math.min(ay2, by2) - Math.max(ay1,by1);

        int overlap = 0;

        if(width > 0 && height > 0){
            overlap = width * height;
        }
        return area1 + area2 - overlap;
    }

    //////////////// Length of Longest Subarray With at Most K Frequency \\\\\\\\\\

    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int j = 0;
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while(map.get(nums[i]) > k){
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    //////////////////// Move Zeros TO end \\\\\\\\\\\\\\\\\\\

    public static void moveZeroes(int[] nums) {
        int j  = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
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

       int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
       System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));

       int num[] = {1,2,3,1,2,3,1,2}, k3 = 2;
       System.out.println(maxSubarrayLength(num, k3));

       int nums1[] = {0,1,0,3,12};
       moveZeroes(nums1);
       printarr(nums1);

    }
}
