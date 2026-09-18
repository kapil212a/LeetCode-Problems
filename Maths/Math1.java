package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Math1 {  
      //// REVERSE INTEGER //// 

    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int last = x % 10;
             
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && last > 7)){
                return 0;
            }
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && last < -8)){
                return 0;
            }

            rev = rev * 10 + last;
             x = x/10;
        }
        return rev;
    }

    ///// Number Is Palindrome or not /////
    
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int num = x;
        int rev = 0;
        while(x != 0){
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x/10;
        }
        return num == rev;
    }

    ////////////////////// CLIMBING STAIR \\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int oneStep = 2;
        int twoStep = 1;

        for(int i = 3; i <= n; i++){
            int curr = oneStep + twoStep;

            twoStep = oneStep;
            oneStep = curr;
        }
        return oneStep;
    }
    
    ///////////// CLACULATE SQURE ROOT VALUE \\\\\\\\\\\\\\\\

    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        int ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long sqr = (long) mid * mid;
            if(sqr == x){
                return mid;
            }

            if(sqr < x){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }

    
    //////////// PERMUTATION SEQUENCE \\\\\\\\\\\\

    public static String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();

        int fact = 1;
        for(int i = 1; i < n; i++){
            fact *= i;
        }
        for(int i = 1; i <= n; i++){
            num.add(i);
        }
        k = k - 1;

        StringBuilder str = new StringBuilder();
        while(num.size() > 0){
            int idx = k / fact;

            str.append(num.get(idx));

            num.remove(idx);

            if(num.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / num.size();
        }
        return str.toString();
    }
    ////////// FIND UNIQE PATH IN M * N  GRID \\\\\\\\\\\\\
    
    public static int uniquePaths(int m, int n) {
        // int dp [][] = new int[m][n];

        // for(int i = 0; i < n; i++){
        //     dp[0][i] = 1;
        // }
        // for(int i = 0; i < m; i++){
        //     dp[i][0] = 1;
        // }

        // for(int i = 1; i < m; i++){
        //     for(int j = 1; j < n; j++){
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }
        // return dp[m -1][n -1];

        int dp[] = new int [n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    ///////////////////// REmove Dublicates from sorted array \\\\\\\\\\\\\\\\\

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int j = 0;
        for(int num : nums){
            if(j < 2 || num != nums[j - 2]){
                nums[j] = num;
                j++;
            }
        }
        return j;
    }


     ///////////////// Grey Code \\\\\\\\\\\\\\\\\\\\\

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for(int i = 0; i < n; i++){
            int size = result.size();

            int value = 1 << i;
            for(int j = size - 1; j >= 0; j--){
                result.add(result.get(j) + value);
            }
        }
        return result;
    }

     ///////////////////// Combination \\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(1, n, k, new ArrayList<>(), ans);
        return ans;
    }
    private static void helper(int start, int n, int k, List<Integer>list, List<List<Integer>>ans){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            helper(i + 1, n, k, list, ans);
            list.remove(list.size() - 1);
        }
    }

    ////////////////////Concatenate Non-Zero Digits and Multiply by Sum I \\\\\\\\\\\\

    public static long sumAndMultiply(int n) {
        int sum = 0;
        int total = 0;
        int place = 1;
        while(n > 0){
            int digit = n % 10;
            if(digit != 0){
                total = total + digit * place;
                sum += digit;
                place = place * 10;
            }
            n = n / 10;
        }
        return 1L * total * sum;
    }

     /////////////////Pascal's Triangle\\\\\\\\\\

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }
                else{
                    int left = ans.get(i - 1).get(j - 1);
                    int right = ans.get(i - 1).get(j);

                    row.add(left + right);
                }
            }
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));

        int num3 = -131;
        System.out.println(isPalindrome(num3));

        int n2 = 5;
        System.out.println(climbStairs(n2));

        int x1 = 10;
        System.out.println(mySqrt(x1));

        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n , k));

        int n1 = 3, m1 = 7;
        System.out.println(uniquePaths(m1, n1));

        int arr[] = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));

        int n3 = 4;
        System.out.println(grayCode(n3));

        int n4 = 4, k4 = 2;
        List<List<Integer>> list = combine(n4, k4);
        System.out.println(list);

        int n0 = 10203004;
       System.out.println(sumAndMultiply(n0));

       int numRows = 5;
         List<List<Integer>> ans = generate(numRows);
       System.out.println(ans);
    }
}
