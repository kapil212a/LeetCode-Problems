import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week7 {
    public static int numDistinct(String s, String t) {
        Integer [][] dp = new Integer [t.length()][s.length()];
        return solve(t,s,t.length() - 1, s.length() -1 , dp);
    }

    public static int solve(String t, String s, int i, int j, Integer dp[][]){
        if(i < 0){
            return 1;
        }
        if(j < 0){
            return 0;
        }
        if(j < i){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(t.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(t, s, i - 1, j -1, dp) + solve(t, s, i , j - 1,dp);
        }
        return dp[i][j] = solve(t, s, i, j - 1,dp);
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

    ////////////////// Best Time to Buy and Sell Stock\\\\\\\\\\\\\\\\\\\
    
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;

            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    ////////////////// Best Time to Buy and Sell Stock\\\\\\\\\\\\\\\\\\\

    public static int maxProfitII(int[] prices) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    //////////////// Valid Palindrom \\\\\\\\\\\\\\\\\\\\\\

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            char ch1 = Character.toLowerCase(s.charAt(left));
            char ch2 = Character.toLowerCase(s.charAt(right));

            if(ch1 != ch2){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    ///////////////// Remove covered Intervals \\\\\\\\\\\\\\\\\

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a, b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int max = 0;

        for(int[] num : intervals){
            if(num[1] > max){
                count++;
                max = num[1];
            }
        }
        return count;
    }



    public static void main(String[] args) {
       String s = "rabbbit", t = "rabbit";
       System.out.println(numDistinct(s, t));

       int numRows = 5;
         List<List<Integer>> ans = generate(numRows);
       System.out.println(ans);

       int prices[] = {7,1,5,3,6,4};
       System.out.println(maxProfit(prices)); 
       
       System.out.println(maxProfitII(prices));

       String s1 = "A man, a plan, a canal: Panama";
       System.out.println(isPalindrome(s1));
       
    }
}
