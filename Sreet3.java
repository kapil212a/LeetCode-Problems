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




    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));

        int n = 520;
        System.out.println(maxProduct(n));

        String s1 = "babab";
        System.out.println(smallestPalindrome(s1));
    }
}
