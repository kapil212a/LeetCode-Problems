package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Array8 {
    public static void printArr(int []arr){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + " ");
        }System.out.println(']');
    }

    //////////////////// 3 Smallest Sum in Array \\\\\\\\\\\\\\\\

    public static int smallest3Sum(int arr[], int target){
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        for(int i = 0; i < n - 2; i++){

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum > target){
                    count += right - left;
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }

    //////////////////// Single Number III Once At A time In Array\\\\\\\\\\\\\\\\\\\

    public static int[] singleNumber(int[] nums) {
        int []count = new int[2];
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int j = 0;
        
        for(int num : map.keySet()){
            if(map.get(num) == 1){
                count[j++] = num;
            }
        }
        return count;
    }

    

    ////////////////////// Distribute Element into 2 part \\\\\\\\\\\\\\\\\\\\

    public static int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int res[] = new int[nums.length];

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++){
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }

        }
        int idx = 0;
        for(int num : arr1){
            res[idx++] = num;
        }
        for(int num : arr2){
            res[idx++] = num;
        }
        return res;
    }

    ///////////////// Smallest Stable Index I \\\\\\\\\\\\\\\\\

    public static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n];

        prefix[n - 1] = nums[n -1];

        for(int i = n - 2; i >= 0; i--){
            prefix[i] = Math.min(nums[i], prefix[i + 1]);
        }
       // printArr(prefix);
        int max = nums[0];

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            int diff = max - prefix[i];

            if(diff <= k){
                return i;
            }
        }
        return -1;

    }

    ////////////////// Construct Uniform Parity Array II \\\\\\\\\\\\\\\

    public static boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for(int x : nums1){
            min = Math.min(min, x);
        }
        if(min % 2 == 1){
            return true;
        }
        for(int x : nums1){
            if(x % 2 == 1){
                return false;
            }
        }
        return true;
    }

     ///////////Remove Min And Max From Array reyurn posibility \\\\\\\\\\\\\

    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < nums[min]){
                min = i;
            }

            if(nums[i] > nums[max]){
                max = i;
            }
        }
        if(min > max){
            int temp = min;
            min = max;
            max = temp;
        }

        int front = max + 1;
        int back = n - min;

        int both = (min + 1) + (n - max);

        return Math.min(front, Math.min(back, both));
    }


    /////////////// Product Of Array Except Self \\\\\\\\\\\\\\\\\\\\\\\

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int j = 1;

        for(int i = 0; i < n; i++){
            ans[i] = j;
            j = j * nums[i];
        }
        int k = 1;
        for(int i = n - 1; i >= 0; i--){
            ans[i] *= k;
            k = k * nums[i];
        }
        return ans;
    }

    ////////////// Rectangle overlap \\\\\\\\\\\\\\

    public static  boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int left = Math.max(rec1[0], rec2[0]);
        int right = Math.min(rec1[2], rec2[2]);

        int bottom = Math.max(rec1[1], rec2[1]);
        int top = Math.min(rec1[3], rec2[3]);

        return left < right && bottom < top;
    }


    
    public static void main(String[] args) {
        int arr[] = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(smallest3Sum(arr, target));

        int nums[] = {1,2,1,3,2,5};
        //System.out.println(singleNumber(nums));
        printArr(singleNumber(nums));

        int arr1[] = {5,4,3,8};
        printArr(resultArray(arr1));

        int arr4[] = {5,0,1,4};
        int k = 3;
        System.out.println(firstStableIndex(arr4, k));

        int arr3[] = {1,4,7};
        System.out.println(uniformArray(arr3));

        int arr5[] = {2,5,6,0,0,1,2};
        System.out.println(minimumDeletions(arr5));
        //printArr(minimumDeletions(arr1));

        int arr2[] = {1, 2, 3, 4};
        printArr(productExceptSelf(arr2));

        int rec1[] = {0,0,2,2};
        int rec2[] = {0,0,2,2};
        System.out.println(isRectangleOverlap(rec1, rec2));
        

    }
}
