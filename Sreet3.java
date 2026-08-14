//import java.util.HashSet;

public class Sreet3 {
    
    /////////////////////// Number of Substrings Containing All Three Characters\\\\\\\\\\\\

    public static int numberOfSubstrings(String s) {
        int [] count = new int[3];

        int left = 0;
        int ans = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            count[s.charAt(i) - 'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += n - i;

                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }

    ////////////////////// Maximum Product of two digit \\\\\\\\\\\\\\\\\\\

    public static int maxProduct(int n) {
       int max1 = 0;
       int max2 = 0;
       

        while(n > 0){
            int digit  = n % 10;
            n = n / 10;

            if(digit > max1){
                max2 = max1;
                max1 = digit;
            }
            else if(digit > max2){
                max2 = digit;
            }
        } 
        return max1 * max2;
    }

    //////////////////Smallest Palindromic Rearrangement I \\\\\\\\\\\\\\\\\\\


    public static String smallestPalindrome(String s) {
        int frq[] = new int [26];

        for(char ch : s.toCharArray()){
            frq[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        char mid = 0;

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < frq[i] / 2; j++){
                ans.append((char)('a' + i));
            }

            if(frq[i] % 2 == 1){
                mid = (char)('a' + i);
            }
        }
        String right = new StringBuilder(ans).reverse().toString();

        if(mid == 0){
            return ans.toString() + right;
        }
        else{
            return ans.toString() + mid + right;
        }
    }

    //////////////////////// predict the winner \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

     public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int score = solve(nums, 0, n - 1);
        return score >= 0;
        
    }
    private static int solve(int nums[], int left, int right){
        if(left == right){
            return nums[left];
        }
        int pickleft = nums[left] - solve(nums, left + 1, right);
        int pickright = nums[right] - solve(nums , left, right - 1);
        
        return Math.max(pickleft, pickright);
    }

    //////////////////////// Piles Stone Game \\\\\\\\\\\\\\\\\\\\\\\\\

    static Integer dp[][];
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];
        return solve1(piles , 0, piles.length - 1) > 0;
    }

    private static int solve1(int piles[], int left, int right){
        if(right == left){
            return piles[left];
        }
        if(dp[left][right] != null){
            return dp[left][right];
        }

       int leftMax = piles[left] - solve1(piles, left + 1, right);
       int rightMax = piles[right] - solve1(piles, left, right - 1);

       return dp[left][right] =  Math.max(leftMax, rightMax);
    }

    ////////////////// Small Divisibility digit product \\\\\\\\\\\\\\\\\

    public static int smallestNumber(int n, int t) {
        while(n > 0){
            int num = n;
            int sum = 1;
            while(num > 0){
                int last = num % 10;
                sum = sum * last;
                num = num / 10;
            }
            if(sum % t == 0){
                return n;
            }
            else{
                n++;
            }
        }
        return -1;
    }

    ///////////////////Maximum Length Substring With Two Occurrences \\\\\\\\\\\\\

    public static int maximumLengthSubstring(String s) {
        int ans = 0;
        int j = 0;
        int fq[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            fq[s.charAt(i) - 'a']++;

            while(fq[s.charAt(i) - 'a'] > 2){
                fq[s.charAt(j) - 'a']--;
                j++; 
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));

        int n = 520;
        System.out.println(maxProduct(n));

        String s1 = "babab";
        System.out.println(smallestPalindrome(s1));

        int score[] = {1,5,233,7};
        System.out.println(predictTheWinner(score));

        int piles[] = {5,3,4,5};
        System.out.println(stoneGame(piles));

        int digit = 10, t = 2;
        System.out.println(smallestNumber(digit, t));

        String s2 = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s2));
    }
}
