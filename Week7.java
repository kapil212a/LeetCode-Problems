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

    public static void main(String[] args) {
       String s = "rabbbit", t = "rabbit";
       System.out.println(numDistinct(s, t));
    }
}
