import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

    ////// Count the number of spacial character I \\\\\
    
    public static int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower.add(ch);
            }
            else{
                upper.add(ch);
            }
        }

        int count = 0;

        for(char ch = 'a'; ch <= 'z'; ch++){
            if(lower.contains(ch) && upper.contains(Character.toUpperCase(ch))){
                count++;
            }
        }
        return count;
    }

    ////// Count the number of Spacial Character II \\\\\\\\\

    public static int numberOfSpecialChars2(String word) {
        int [] lower = new int [26];
        int [] upper = new int[26];

        Arrays.fill(lower , -1);
        Arrays.fill(upper , -1);

        for(int i = 0; i< word.length(); i++){

            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)){
                lower[ch - 'a'] = i;
            }
            else{
                int idx = ch - 'A';

                if(upper[idx] == -1){
                    upper[idx] = i;
                }
            }
        }
        int count = 0;

        for(int i = 0; i < 26; i++){
            if(lower[i] != -1 && upper[i] != -1 && lower[i] < upper[i]){
                count++;
            }
        }
        return count;
    }
    
    /////// MINIMUM COST FOR BUY CANDIES WITH DISCOUNT \\\\\\\

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length -1;
        int totalcost = 0;
        for(int i = n; i>=0; i -= 3){
            totalcost += cost[i];

            if(i - 1 >= 0){
                totalcost += cost[i -1];
            }
        }
        return totalcost;
    }

    public static int minimumCost1(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        int count = 0;
        for(int i = cost.length - 1; i >= 0; i--){
            count++;

            if(count == 3){
                count = 0;
                continue;
            }
            ans += cost[i];
        }
        return ans;
    }

    /////// EARLIER FINISH TIME FOR LAND AND WATER RIDE TIME II \\\\\\\\

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans1 = solve(landStartTime, landDuration, waterStartTime, waterDuration);

        int ans2 = solve(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(ans1, ans2);
    }
    private int solve(int start1[], int dur1[], int start2[], int dur2[]){
        int minEnd = Integer.MAX_VALUE;

        for(int i = 0; i < start1.length; i++){
            minEnd = Math.min(minEnd, start1[i] + dur1[i]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < start2.length; i++){
            int finish = Math.max(minEnd, start2[i]) + dur2[i];

            ans = Math.min(ans, finish);
        }
        return ans;
    }
    

    public static void main(String[] args) {
        int num [] = {4,5,6,7,0,1,2};
        System.out.println(search(num, 0));

        int arr[] = {4,3,2,6};
        System.out.println(maxRotateFunction(arr));

        int arr1[] = {3,4,5,1,2};
        System.out.println(check(arr1));

        int arr2[] = {6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;
        System.out.println(maxJumps(arr2, d));

        String s = "011010";
        int max = 2;
        int min = 3;
        System.out.println(canReach(s, min, max));

        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word)); 

        String s1 = "aaAbcBC";
        System.out.println(numberOfSpecialChars2(s1));

        int cost[] = {6,5,7,9,2,2};
        System.out.println(minimumCost(cost));
        System.out.println(minimumCost1(cost));

    }
}

