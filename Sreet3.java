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



    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));

        int n = 520;
        System.out.println(maxProduct(n));
    }
}
