package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array1 {
     ////// PRINT ARRAY \\\\\\

    public static void printArray(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    ////////// TRAPING RAINWATER \\\\\\\\\\
     public static int trap(int[] height) {
        int n = height.length;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = height[0];
        for(int i = 1; i< n; i++){
            left[i] = Math.max(left[i -1], height[i]);
        }

        right[n-1] = height[n -1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int totalWater = 0;
        for(int i = 0; i < n; i++){
            totalWater += Math.min(left[i] , right[i]) - height[i];
        }
        return totalWater;
    }

    ///// Collecting Rain Water //////
    
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;

        int maxwater = 0;

        while(left < right){
            int width = right - left;
            int minHeight = Math.min(height[left] , height[right]);
            int area = minHeight * width;
            maxwater = Math.max(maxwater , area);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxwater;
    }

     //// Minimum Distnace from target////
    
    public static int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                int distance = Math.abs(i - start);
                minDistance = Math.min(minDistance , distance);
            }
        }
        return minDistance;
    }

    
    //////// MIDIAN OF TWO SORTED ARRAY \\\\\\\\
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int merge[] = new int [m+n];

        int i = 0 , j= 0 , k = 0;
        while(i< m && j< n){
            if(nums1[i] < nums2[j]){
                merge[k] = nums1[i];
                k++;
                i++;
            }else{
                merge[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < m){
            merge[k] = nums1[i];
            k++;
            i++;
        }
        while(j < n){
            merge[k] = nums2[j];
            k++;
            j++;
        }

        int total = m + n;

        if(total % 2 == 0){
            double mid = (merge[total/2 - 1] + merge[total/2]) / 2.0;
            return mid;
        }else{
            return merge[total/2];
        }
    }

     //// REMOVE ELEMENT NOT EQUAL TO N  AND RETUEN \\\\
    public static int removeElement(int[] nums, int val) {
       int a = 0;

       for(int i = 0; i < nums.length ; i++){
            if(nums[i] != val){
                nums[a] = nums[i];
                a++;
            }
        
       }
       return a; 
    }

    /////// REMOVE DUBLICATE FROM SORTED ARRAY AND RETURN COUNT  \\\\\\\\\\
    
    public static int removeDuplicates(int[] nums) {
        int i =0;

        for(int j = 1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
    return i+1;
    }

    //// Longest Common Prefix ////////
    
    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for(int i = 0; i < first.length(); i++){
            char ch = first.charAt(i);

            for(int j = 1; j < strs.length; j++){
                
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }

    /// 3 SUM////
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){

                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
                
            }
            
        }
        return list;
    }
//// 3 sum closest////

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for(int i = 0; i<nums.length-2; i++){
            
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - sum) < Math.abs(target - res)){
                    res = sum;
                }
                if(sum == target){
                    return sum;
                }
                else if (sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }

   

///// 4SUM ////// 

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i<n - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j<n-2;j++){
                if(j > i+1 && nums[j] == nums[j -1]){
                    continue;
                }

                int left = j+1;
                int right = n-1;

                while(left < right){
                    long sum =(long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){

                        res.add(Arrays.asList(nums[i] , nums[j] ,nums[left], nums[right]));

                        while(left < right && nums[left] == nums[left +1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right -1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));

        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));

        int nums [] = {1,2,3,4,5};
        int target = 5;
        int start = 3;
        System.out.println(getMinDistance(nums , target , start));

        int nums1[] = {1,2};
        int nums2[] = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        int arr4[] = {3,2,2,3};
        int n1 = 3;
        System.out.println(removeElement(arr4, n1));

        int arr1[] = {1,2,2,3,3};
        System.out.println(removeDuplicates(arr1));

        String [] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

        int arr2[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr2));

        int arr3[] = {-1,2,1,-4};
        int target1 = 1;
        System.out.println(threeSumClosest(arr3, target1));

        

        int arr5[] = {1,0,-1,0,-2,2};
        int target2 = 0;
        System.out.println(fourSum(arr5, target2));

    }
}
