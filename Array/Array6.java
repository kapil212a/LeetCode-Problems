package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Array6 {
     /////////////////////// Maximum Product of three number in Array \\\\\\\\\\\\\\\\\\\

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;

        max = Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);

        return max;
    }

///////////////////// Majority Element In a Array \\\\\\\\\\\\\\\\\\\\\

    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;

        for(int num : nums){
            if(count == 0){
                majority = num;
            }

            if(num == majority) {
                count++;
            }
            else{
                count--;
            }
        }
        return majority;
    }

    ///////////////////// Two Sum II - Input Array Is Sorted \\\\\\\\\\\

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1 , right + 1};
            }
            if(sum > target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }

    /////////////////////// Maximum Gap Between Numbers \\\\\\\\\\\\\\\\\\  
    
    public static int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int diff = 0;
        int max = 0;
        if(nums.length == 1){
            return 0;
        }
        for(int i = 0; i < nums.length - 1; i++){
            diff = nums[i+1] - nums[i];
            max = Math.max(diff , max);
        }
        return max;
    }


    //////////////////////// Rotate The array from kth element \\\\\\\\\\\\\\\\\\\\\\\

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private static void reverse(int nums[] , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    /////////////////////// Robery in not adjucent house and return max money \\\\\\\\\\\\\\\\\\\\\\\\\

    public static int rob(int[] nums) {
        //Arrays.sort(nums);
        int money1 = 0 , money2 = 0;
        for(int i = 0; i < nums.length; i++){
           int max = Math.max(money1 , money2 + nums[i]);
           money2 = money1;
           money1 = max;
        }
        return money1;
    }

    //////////////////// Minimum Size Subarray \\\\\\\\\\\\\\\\\\\\\\
    
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while(sum >= target){
                min = Math.min(min, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    ///////////////////////// House Robery II \\\\\\\\\\\\\\\\\\\\\

    public static int rob1(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }
        int sec = robing(nums, 0, n -2);
        int first = robing(nums, 1, n-1);
        

        return Math.max(first, sec);
    }

    private static int robing(int nums[], int start, int end){
        int prev = 0;
        int curr = 0;

        for(int i = start; i <= end; i++){
            int sum = prev + nums[i];
            int skip = curr;

            int high = Math.max(sum, skip);

            prev = curr;
            curr = high;
        }
        return curr;
    }

    ///////////////////// Finding Missing elements in List \\\\\\\\\\\\\\\\\\

    public static List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int small = nums[0];
        int large = nums[nums.length - 1];

        HashSet<Integer> set = new HashSet<>();

         for(int i = 0; i < nums.length; i++){
           set.add(nums[i]);
        }
        
        for(int i = small; i <= large; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
       
        return ans;
    }


    public static void main(String[] args) {
        int nums1[] = {-100 , -98, -1, 2, 3, 4};
        System.out.println(maximumProduct(nums1));

        int numbers[] = {2,7,11,15};
        int target = 9;
        int nums[] = twoSum(numbers, target);
        System.out.print("[");
        for(int n : nums){
            System.out.print(n + " ");
        }System.out.println("]");

        int num[] = {3,6,9,1};
        System.out.println(maximumGap(num));

        int arr[] = {-1,-100,3,99};
        int k = 2;
        rotate(arr, k);

        //int houses[] = {2,7,9,3,1};
        int house[] = {2, 7, 9, 3, 1};
        System.out.println(rob(house));

        int arr1[] = {2,3,1,2,4,3};
        int number = 10;
        System.out.println(minSubArrayLen(number, arr1));

        int[] nums2 = {1,2,3,1};
        System.out.println(rob1(nums2));

        int num1[] = {1,2,5};
        List<Integer> ans =  findMissingElements(num1);
        System.out.println(ans);


    }
}
