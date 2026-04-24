import java.util.HashMap;
import java.util.Map;

public class Week1 {
    //// Minimum Distnace from target////
    
    public static int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target){
                int distance = Math.abs(i - start);
                minDistance = Math.min(minDistance , distance);
            }
        }
        return minDistance;
    }

    //// Longest Substring Without Repeating Characters////

    public static int lengthOfLongestSubstring(String s) {
        Map <Character , Integer> map = new HashMap<>();
        int left = 0 ,length = 0;

        for(int i = 0; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                left = Math.max(left , map.get(ch) +1);
            }

            map.put(ch , i);
            length = Math.max(length , i - left +1);
        }
        return length;
    }

    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int merge[] = new int [m+n];

        int i = 0 , j= 0 , k = 0;
        while(i< m && j< n){
            if(nums1[i] < nums2[j]){
                merge[k] = nums1[i];
                k++;
                i++;
            }else{
                merge[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < m){
            merge[k] = nums1[i];
            k++;
            i++;
        }
        while(j < n){
            merge[k] = nums2[j];
            k++;
            j++;
        }

        int total = m + n;

        if(total % 2 == 0){
            double mid = (merge[total/2 - 1] + merge[total/2]) / 2.0;
            return mid;
        }else{
            return merge[total/2];
        }
    }

    /////Longest Palindromic Substring//////

    public static String longestPalindrome(String s) {
        int start = 0 , end = 0;
        
        for(int i = 0; i<s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len > end -start){
                start = i-(len -1 ) / 2;
                end = i+ len / 2;
            }
        }
        return s.substring(start , end + 1);
    }

    private static int expand(String s , int left , int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --; 
            right++;
        }
        return right - left -1;
    }


    ////Zic-Zac String Conversion/////
    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows){
            return s;
        }
        StringBuilder[] row = new StringBuilder[numRows];

        for(int i = 0; i< numRows; i++){
            row[i] = new StringBuilder();
        }
        int currRow = 0;
        int down = 1;

        for(char c : s.toCharArray()){
            row[currRow].append(c);

            if(currRow == 0){
                down =1;
            }
            else if(currRow == numRows -1){
                down = -1;
            }
            currRow += down;
        }

        String result = "";
        for(int i = 0; i<numRows; i++){
            result += row[i].toString();
        }
        return result;
    }

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


    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5};
        int target = 5;
        int start = 3;
        System.out.println(getMinDistance(nums , target , start));

        String s = "abccbabac";
        System.out.println(lengthOfLongestSubstring(s));

        int nums1[] = {1,2};
        int nums2[] = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        String s1 = "babad";
        System.out.println(longestPalindrome(s1));

        String s3 = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s3, numRows));

        int x = -123;
        System.out.println(reverse(x));

    }
}
