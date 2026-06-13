import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Street1 {
    ///////// PRINT ARRAY \\\\\\\\
    
    public static void printArray(int arr[]){
        System.out.print("[");
        for(int i : arr){
            System.out.print(i + " ");
        }System.out.println("]");
    }

    //////// Left and Right Sum Differences\\\\\\\\\
    
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int leftSum = 0;

        for(int i = 0; i < n; i++){
            int rightSum = totalSum - leftSum - nums[i];

             ans[i] = Math.abs(rightSum - leftSum);

            leftSum += nums[i];
        }
        return ans;
    }

    /////// PERMUTATION II \\\\\\\\\\
    
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        boolean used[] = new boolean [n];

        backtrack(nums, used, new ArrayList(), ans);

        return ans;
    }
    private static void backtrack(int [] nums, boolean[] used, List<Integer> curr, List<List<Integer>> ans){

        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);

            backtrack(nums, used, curr, ans);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    //////// Partition Array According to Given Pivot \\\\\\\\\

     public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int [] ans = new int [n];

        int idx = 0;

        for(int num : nums){
            if(num < pivot){
                ans[idx] = num;
                idx++;
            }
        }
        for(int num : nums){
            if(num == pivot){
                ans[idx] = num;
                idx++;
            }
        }
        for(int num : nums){
            if(num > pivot){
                ans[idx] = num;
                idx++;
            }
        }
        return ans;
    }

    //////////// POWER OF X ^ n \\\\\\\\\\\\\

    public static double myPow(double x, int n) {
        long power = n;

        if(power < 0){
            x = 1 / x;
            power  = -power;
        }

        double ans = 1;
        while(power > 0){
            if(power % 2 == 1){
                ans *= x;
            }

            x *= x;
            power /= 2;
        }
        return ans;
    }

    ///////// MAXIMUM SUBARRAY SUM \\\\\\\\

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ms = nums[0];

        for(int i = 1; i < nums.length; i++){
            int num = nums[i];

            if(sum + num > num){
                sum = sum + num;
            }else{
                sum = num;
            }
            if(sum > ms){
                ms = sum;
            }
        }
        return ms;
    }

    /////////// Weighted Word Mapping \\\\\\\\\

    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for(String word : words){
            int weight = 0;

            for(char ch : word.toCharArray()){
                int idx = ch - 'a';

                weight += weights[idx];

            }
            int rem = weight % 26;

            char map = (char)('z' - rem);
            ans.append(map);
        }
        return ans.toString();
    }



    public static void main(String[] args) {
        int nums[] = {10,4,8,3};
        printArray(leftRightDifference(nums));

        int nums1[] = {1,1,2};
        System.out.println(permuteUnique(nums1));

        int nums2[] = {9,12,5,10,14,3,10};
        int pivot = 10;
        printArray(pivotArray(nums2, pivot));

        System.out.println(myPow(2, 10));

        int nums3 [] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums3));

        
    }
}
