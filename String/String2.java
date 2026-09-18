package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class String2 {
     /// Latter Combination Of Phone Number ////
    
     static List <String> res = new ArrayList<>();

        static String[] comb = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
    
    public static List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
            return res;
        }

        backtrack(digits,0,"");
        return res;

    }
    public static void backtrack(String digits , int idx, String curr){
        if(idx== digits.length()){
            res.add(curr);
            return;
        }
        String letter = comb[digits.charAt(idx)- '0'];
        for(int i =0; i<letter.length(); i++){
            backtrack(digits,idx +1, curr+letter.charAt(i));
        }
    }

    ///// FIND THE INDEX OF THE FIRST OCCURENCE IN A STRING \\\\
    
     public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i<= n-m; i++){
            int j = 0;

            while(j < m && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j == m){
                return i;
            }
        }
        return -1;
    }

    //////////////// Simplify Path \\\\\\\\\\\\\\\\

    public static String simplifyPath(String path) {
        Stack<String> st= new Stack<>();

        String [] folder = path.split("/");

        for(String str : folder){
            if(str.equals("") || str.equals(".")){
                continue;
            }
            if(str.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(str);
            }

        }
        StringBuilder ans = new StringBuilder();

        for(String str : st){
            ans.append("/");
            ans.append(str);
        }
        if(ans.length() == 0){
            return "/";
        }
        else{
            return ans.toString();
        }
    }

    

    //// SUBSTRING WITHCONCATINATION OF ALL WORD \\\\\\

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if(s.length() == 0 || words.length == 0){
            return ans;
        }
        int wordLen = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLen * totalWords;

        HashMap<String , Integer > map = new HashMap<>();

        for(String word : words){
            map.put(word , map.getOrDefault(word , 0) + 1);
            
        }
        for(int i = 0; i <= s.length() - windowSize; i++){

            HashMap <String , Integer> seen = new HashMap<>();

            int j = 0;
            while(j < totalWords){
                int start = i + j * wordLen;

                String part = s.substring(start , start + wordLen);

                if(!map.containsKey(part)){
                    break;
                }
                seen.put(part , seen.getOrDefault(part , 0) + 1);

                if(seen.get(part) > map.get(part)){
                    break;
                }
                j++;
            }
            if(j== totalWords){
                ans.add(i);
            }
        }
        return ans;
    }

    ///////// LENGTH OF LAST STRING \\\\\\\\\\\\\\

    public static int lengthOfLastWord(String s) {
        int n = s.length() -1;

        while(n >= 0 && s.charAt(n) == ' '){
            n--;
        }

        int length = 0;

        while(n >= 0 && s.charAt(n) != ' '){
            length++;
            n--;
        }
        return length;
    }


    ///////// ADD BINARY \\\\\\\\\\\\\
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            ans.append(sum % 2);
            carry = sum /2;
        }
        return ans.reverse().toString();
    }

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

    public static void main(String[] args) {
        String s1 = "23";
        System.out.println(letterCombinations(s1));

        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));

        String s = "barfoothefoobarman";
        String words[] = {"foo","bar"};
        System.out.println(findSubstring(s, words));

        
        String str1 = "Hello World";
        System.out.println(lengthOfLastWord(str1));

        String path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));

         String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));

        String s0 = "rabbbit", t = "rabbit";
       System.out.println(numDistinct(s0, t));

       String s3 = "A man, a plan, a canal: Panama";
       System.out.println(isPalindrome(s3));
    }
}
