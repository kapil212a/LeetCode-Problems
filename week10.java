import java.util.Arrays;
import java.util.HashSet;

public class week10 {
    /////////////////Concatenation of Consecutive Binary Numbers \\\\\\\\\\\\\\\\\
    public static int concatenatedBinary(int n) {
        long sum = 0;
        long mod = 1000000007;
        for(int i = 1 ; i <= n; i++){
            int val = Integer.toBinaryString(i).length();
            sum = ((sum << val) | i) % mod;
        }
        return (int)sum;
    }

    //////////////////////// Rotate The array from kth element \\\\\\\\\\\\\\\\\\\\\\\

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private static void reverse(int nums[] , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    /////////////////////// Robery in not adjucent house and return max money \\\\\\\\\\\\\\\\\\\\\\\\\

    public static int rob(int[] nums) {
        //Arrays.sort(nums);
        int money1 = 0 , money2 = 0;
        for(int i = 0; i < nums.length; i++){
           int max = Math.max(money1 , money2 + nums[i]);
           money2 = money1;
           money1 = max;
        }
        return money1;
    }

    ///////////////////// Count the no. of pushes to type word in keypad \\\\\\\\\\\\\\\\\\\\\

    public static int minimumPushes(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            count += (i / 8) + 1;
        }
        return count;
    }

    ////////////////////Count the no. of pushes to type word in keypad II \\\\\\\\\\\\\\\\\\\\\\

    public static int minimumPushesII(String word) {
        int count = 0;
        int frq[] = new int[26];

        for(int i = 0; i < word.length(); i++){
            frq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(frq);
        int push = 0;

        for(int i = 25; i >= 0; i--){
            push += frq[i] * ((count / 8) + 1);
            count++;
        }
        return push;
    }


    /////////////////// Spacial Position In Binary Matrix \\\\\\\\\\\\\\\\\\\\\\

    public static int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int row [] = new int[n];
        int col[] = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    count++;
                }
            }
        }
        return count; 
    }

    ///////////////////////Make Alternate Binary String return no. of operation \\\\\\\\\\\\\\\\\\\\\\\\

    public static int minOperations(String s) {
        int n = s.length();
        int count1 = 0 , count2 = 0;
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                if(s.charAt(i) == '1'){
                    count1++;
                }
            }
            else{
                if(s.charAt(i) == '0'){
                    count1++;
                }
            }
            if(i % 2 == 0){
                if(s.charAt(i) == '0'){
                    count2++;
                }
            }
            else{
                if(s.charAt(i) == '1'){
                    count2++;
                }
            }
        }
        return Math.min(count1, count2);
    }

    /////////////////Check if Binary String Has at Most One Segment of Ones \\\\\\\\\\\\\\\\\\\\

    public static boolean checkOnesSegment(String s) {
        int n = s.length();
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == '0' && s.charAt(i + 1) == '1'){
                return false;
            }
        }
        return true;
    }

     //////////////////// find unique binary string \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        HashSet<String> set = new HashSet<>();

        for(String str : nums){
            set.add(str);
        }

        for(int i = 0; i < (1 << n); i++){
            String binary = Integer.toBinaryString(i);

            while(binary.length() < n){
                binary = "0" + binary;
            }

            if(!set.contains(binary)){
                return binary;
            }
        }
        return "";
    }



    public static void main(String[] args) {
        int n = 3;
        System.out.println(concatenatedBinary(n));

        int arr[] = {-1,-100,3,99};
        int k = 2;
        rotate(arr, k);

        //int houses[] = {2,7,9,3,1};
        int house[] = {2, 7, 9, 3, 1};
        System.out.println(rob(house));

        String word = "xycdefghij";
        System.out.println(minimumPushes(word));

        String word2 = "xyzxyzxyzxyz";
        System.out.println(minimumPushesII(word2));

        int mat[][] = {
            {1,0,0},
            {0,0,1},
            {1,0,0}
        };
        System.out.println(numSpecial(mat));

        String s1 = "1111";
        System.out.println(minOperations(s1));

        String s2 = "1100";
        System.out.println(checkOnesSegment(s2));

        String nums[] = {"10", "01"};
        System.out.println(findDifferentBinaryString(nums));

        
        
    }
}
