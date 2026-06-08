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

    public static void main(String[] args) {
        int nums[] = {10,4,8,3};
        printArray(leftRightDifference(nums));

        int nums1[] = {1,1,2};
        System.out.println(permuteUnique(nums1));

        
    }
}
