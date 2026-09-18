package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Array4 {
    ///////////////// Print Arrays \\\\\\\\\\\\\\\\\\\\

    public static void printArray(int arr[]){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + " ");
        }System.out.println("]");
    }
    ////////////////////// Subset II \\\\\\\\\\\\\\\\\\\\

    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());

        return ans;
    }

    private static void backtrack(int nums[] , int idx, List<Integer> curr){
        ans.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i -1]){
                continue;
            }

            curr.add(nums[i]);
            backtrack(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    ////////////////// Merge Sorted Arrays \\\\\\\\\\\\\\\\\\\\\\
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n -1, k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }

    }

     //////////////////// Search In sorted Array \\\\\\\\\\\\\\\\\\\\\\\\\

    public static boolean search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid]){
                left++;
            }
            else if(nums[left] < nums[mid]){
                if(target >= nums[left] && nums[mid] > target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    ///////////////////// Maximum Ice Cream Bars \\\\\\\\\\\\\\\\\\\
    
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int bars = 0;

        for(int cost : costs){
            if(coins < cost){
                break;
            }
            coins -= cost;
            bars++;
        }
        return bars;
    }

   
    /////////////////////////// Subset Of Given Nums \\\\\\\\\\\\\\\\\\\\\\

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(0 , nums, new ArrayList<>() , ans);
        return ans;
    }

    private static void helper(int start, int []nums, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);

            helper(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    /////////////// Majority Element \\\\\\\\\\\\\\\\\\\

    public static int majorityElement(int[] nums) {
        int ele = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                ele = num;
            }

            if(ele == num){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }

    ////////////// Longest Balence SubArrays I \\\\\\\\\\\\\\\\\\

    public static int longestBalanced(int[] nums) {
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            HashSet<Integer> seen = new HashSet<>();

            int even = 0, odd = 0;
            for(int j = i; j < nums.length; j++){
                if(!seen.contains(nums[j])){
                    seen.add(nums[j]);
                    if(nums[j] % 2 == 0){
                        even++;
                    }
                    else{
                        odd++;
                    }
                }
                if(even == odd){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    ///////////// FInd The Single Number That Is Not Repeated \\\\\\\\\\\\\\

    public static int singleNumber(int[] nums) {
        int find = 0;

        for(int i = 0; i < nums.length; i++){
            find = find ^ nums[i];

        }
        return find;
    }

    public static void main(String[] args) {
        int[] nums5 = {1,2,2};
        List<List<Integer>> x = subsetsWithDup(nums5);
        System.out.println(x);

        int nums2[] = {1,2,3,0,0,0};
        int nums3[] = {2,5,6};
        int m = 3, n1 = 3;
        merge(nums2, m, nums3, n1);
        printArray(nums2);

        int arr1[] = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(arr1, target));

        int costs[] = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));

        int nums1[] = {1,2,3};
        List<List<Integer>> list1 = subsets(nums1);
        System.out.println(list1);

        int nums4[] = {2,2,1,1,1,2,2};
       System.out.println(majorityElement(nums4));

       int nums[] = {2,5,4,3};
       System.out.println(longestBalanced(nums));

       int nums0[] = {4,1,2,1,2};
       System.out.println(singleNumber(nums0));


    }
}
