public class Street {
    //// Search In rotated Sorted Array //////
   
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid -1;
                }
                else{
                    left = mid +1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                }
                else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    /// Maximum Sum Of rotating Array By Multiplying With Index Number////
    
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int res = 0;
        int total = 0;
        for(int i = 0; i<nums.length; i++){
            res += nums[i];
            total += nums[i] * i;
        }
        int current = total;
        int max = total;

        for(int i = 1; i<n; i++){
            current = current + res - n * nums[n-i];

            max = Math.max(current, max);
        }
        return max;
    }


    public static void main(String[] args) {
        int num [] = {4,5,6,7,0,1,2};
        System.out.println(search(num, 0));

        int arr[] = {4,3,2,6};
        System.out.println(maxRotateFunction(arr));
    }
}

