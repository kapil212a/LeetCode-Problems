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

    public static void main(String[] args) {
        
    }
}
