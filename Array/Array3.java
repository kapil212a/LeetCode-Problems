package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Array3 {
    
    ////////// PRINT 1D ARRAYS \\\\\\\\\\\\\\\
    public static void printArray(int arr[]){
        System.out.print("[");
        for(int i : arr){
            System.out.print(i +" ");
        }System.out.println("]");
    }

    
    /////////// EARLIER FINISH TIME OF WATER AND LAND \\\\\\\\\
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i< landStartTime.length; i++){
            int landFinish = landStartTime[i] + landDuration[i];

            for(int j = 0; j < waterStartTime.length; j++){
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finish = waterStart + waterDuration[j];

                ans = Math.min(ans, finish);
            }
        }

        for(int i = 0; i < waterStartTime.length; i++){
            int waterFinish = waterStartTime[i] + waterDuration[i];

            for(int j = 0; j < landStartTime.length; j++){
                int landStart = Math.max(waterFinish, landStartTime[j]);
                int finish = landStart + landDuration[j];

                ans = Math.min(ans, finish);
            }
        }
        return ans;
    }

    //////// FIRST MISSING POSITIVE NUMBER \\\\\\\\\

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        int i = 0;

        while(i < n){
            int correct = nums[i] - 1;

            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }
        for(i = 0; i < n; i++){
            if(nums[i] != i +1){
                return i + 1;
            }
        }
        return n + 1;
    }

    //////// JUMP GAME II \\\\\\\\

    public static int jump(int[] nums) {
        int jump = 0;
        int curr = 0;
        int farth = 0;

        for(int i = 0; i < nums.length - 1; i++){
            farth = Math.max(farth , i + nums[i]);
            if(i == curr){
                jump++;
                curr = farth;
            }
        }
        return jump;
    }

    ////////// PERMUTATION \\\\\\\\\\

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(0 , nums,ans);

        return ans;
    }
    private static void solve(int idx , int [] nums , List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        for(int i = idx; i < nums.length; i++){
            swap(nums , idx, i);
            solve(idx + 1 , nums , ans);
            swap(nums , idx, i);
        }
    }
    private static void swap(int nums[] , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /////////// GROUP  ANAGRAM OF STRING \\\\\\\\\

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String> > map = new HashMap<>();

        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    ///////////////  Minimize Maximum Pair Sum in Array \\\\\\\\\\\\\

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;

        int ans = 0;

        while(i < j){
            int sum = nums[i] + nums[j];
            ans = Math.max(ans ,sum);

            i++;
            j--;
        }
        return ans;
    }

    ///////////////// PLUS ONE AT THE LAST OF DIGIT IN ARRAYS \\\\\\\\\\\\

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n -1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int [] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    ////////////////// Sort The color \\\\\\\\\\\\\\\\\\ 
    
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap1(nums, mid, high);
                high--;
            }
        }
    }
    private static void swap1(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /////////////////// Divide an Array Into Subarrays With Minimum Cost I \\\\\\\\\\\\

    public static int minimumCost(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < firstMin){
                secMin = firstMin;
                firstMin = nums[i];
            }
            else if(nums[i] < secMin){
                secMin = nums[i];
            }
        }
        return nums[0] + firstMin + secMin;
    }
    
    //////////// Find Smallest Letter Greater then Target \\\\\\\\\\\\\\\\\\\\

    public static char nextGreatestLetter(char[] letters, char target) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;  i < letters.length; i++){
            min = Math.min(min, letters[i] - target);
        }
        //return letters[0];
        return (char)(target + min);
    }

    public static void main(String[] args) {
        int landStartTime[] = {2,8}, landDuration[] = {4,1};
       int waterStartTime [] = {6}, waterDuration[] = {3};
       System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));

       int nums[] = {7,8,9,11,12};
       System.out.println(firstMissingPositive(nums));

        int nums1[] = {2,3,1,1,4};
       System.out.println(jump(nums1));

       int nums2[] = {1,2,3};
       System.out.println(permute(nums2));

       String str[] = {"eat","tea","tan","ate","nat","bat"};
       System.out.println(groupAnagrams(str));

       int nums5[] = {3,5,2,3};
        System.out.println(minPairSum(nums5));

        int digits[] = {4,3,2,9};
        printArray(plusOne(digits));

        int nums3[] = {2,0,2,1,1,0};
        sortColors(nums3);
        printArray(nums);

         int num6[] = {10,3,1,1};
        System.out.println(minimumCost(num6));

        char letters[] = {'h','c','f','j'};
        char target1 = 'a';
        System.out.println(nextGreatestLetter(letters, target1));
    }
}
