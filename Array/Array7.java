package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Array7 {
    public static void printarr(int arr[]){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + " ");
        }System.out.println("]");
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

    ////////////////// Summary Range \\\\\\\\\\\\\\\\\\

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if(nums.length == 0){
            return ans;
        }

        int start = nums[0];
        for(int i = 1; i <= nums.length; i++){
            if(i == nums.length || nums[i] != nums[i - 1] + 1){
                if(start == nums[i - 1]){
                    ans.add(String.valueOf(start));
                }
                else{
                    ans.add(start + "->" + nums[i - 1]);
                }
                 if(i < nums.length){
                    start = nums[i];
                }
            }
           
        }
        return ans;
    }

    /////////////////////////////// Majority Element \\\\\\\\\\\\\\\\\\\\\\\\\\\

     public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int size = n / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if(map.get(nums[i]) > size && !ans.contains(nums[i])){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    ////////////////////////// H - Index \\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for(int i = 0; i < n; i++){
            int index = n - i;

            if(citations[i] >= index){
                return index;
            }
        }
        return 0;
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
        int num[] = {1,2,3,1,2,3,1,2}, k3 = 2;
       System.out.println(maxSubarrayLength(num, k3));

       int nums1[] = {0,1,0,3,12};
       moveZeroes(nums1);
       printarr(nums1);

       int nums2[] = {0,1,2,4,5,7};
       List<String> ans1 = summaryRanges(nums2);
       System.out.println(ans1);

       int nums3[] = {3,2,3};
       List<Integer> majority =  majorityElement(nums3);
       System.out.println(majority);

      int []citations = {3,0,6,1,5};
      System.out.println(hIndex(citations));

      int arr[] = {1,1,1,3,3,4,3,2,4,2};
       System.out.println(containsDuplicate(arr));

       int arr1[] =  {1,2,3,1};
       int k2 = 3;
       System.out.println(containsNearbyDuplicate(arr1, k2));

        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));


    }
}
