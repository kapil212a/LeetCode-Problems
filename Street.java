import java.util.LinkedList;
import java.util.Queue;

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

    /// Check The Array Is Sorted And Rotated///
    
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] > nums[(i + 1 )% n]){
                count++;
            }
        }
        return count <= 1;
    }
    
    ////jump Game V/////
    
    public static int maxJumps(int[] arr, int d) {
        int n =arr.length;
        int dp[] = new int[n];
        int ans =1;

        for(int i = 0; i< n; i++){
            ans = Math.max(ans, dfs(arr, d, i, dp));
        }

        return ans;
    }

    public static int dfs(int[] arr, int d, int index, int[] dp){

        if(dp[index] != 0){
            return dp[index];
        }

        int max = 1;

        for(int i = index + 1; i<= Math.min(arr.length - 1, index + d); i++){
            if(arr[i] >= arr[index]){
                break;
            }

            max = Math.max(max , 1 + dfs(arr, d, i, dp));
        }

        for(int i = index - 1; i>=Math.max(0, index -d); i--){
            if(arr[i] >= arr[index]){
                break;
            }
            max = Math.max(max , 1 + dfs(arr, d, i, dp));
        }

        dp[index] = max;
        return max;
    }

///// Jump Game VII ///////

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> que = new LinkedList<>();

        que.offer(0);
        int fast = 0;

        while(!que.isEmpty()){
            int curr = que.poll();

            int start = Math.max(curr + minJump, fast + 1);

            int end = Math.min(curr + maxJump , n-1);

            for(int i = start; i <= end; i++){
                if(s.charAt(i) == '0'){
                    if(i == n -1){
                        return true;
                    }
                    que.offer(i);
                }
            }
            fast = curr + maxJump;
        }
        return n == 1;
    }


    public static void main(String[] args) {
        int num [] = {4,5,6,7,0,1,2};
        System.out.println(search(num, 0));

        int arr[] = {4,3,2,6};
        System.out.println(maxRotateFunction(arr));

        int arr1[] = {3,4,5,1,2};
        System.out.println(check(num));

        int arr2[] = {6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;
        System.out.println(maxJumps(arr2, d));

        String s = "011010";
        int max = 2;
        int min = 3;
        System.out.println(canReach(s, min, max));
    }
}

