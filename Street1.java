public class Street1 {
    ///////// PRINT ARRAY \\\\\\\\
    
    

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
    public static void main(String[] args) {
        int nums[] = {10,4,8,3};
        printArray(leftRightDifference(nums));

    }
}
