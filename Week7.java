import java.util.ArrayList;
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

        for(int i = 0; i < prices.length; i++){
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



    public static void main(String[] args) {
       String s = "rabbbit", t = "rabbit";
       System.out.println(numDistinct(s, t));

       int numRows = 5;
         List<List<Integer>> ans = generate(numRows);
       System.out.println(ans);

       int prices[] = {7,1,5,3,6,4};
       System.out.println(maxProfit(prices));
       
    }
}
