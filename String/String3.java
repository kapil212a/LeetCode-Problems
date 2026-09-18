package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class String3 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet < String> set = new HashSet<>(wordDict);

        int n = s.length();

        boolean dp[] = new boolean[n + 1];

        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        } 
        return dp[n];
    }

    /////////////////////Longest Balance Substring I \\\\\\\\\\\\\\\\\\\\\
    
    public static int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int frq[] = new int[26];

            int dist = 0;
            int max = 0;

            for(int j = i; j < n; j++){
                int idx = s.charAt(j) - 'a';

                if(frq[idx] == 0){
                    dist++;
                }
                frq[idx]++;
                max = Math.max(max , frq[idx]);

                int len = j - i + 1;

                if(len == max * dist){
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }

    ////////////////// Reverse the Word in the string \\\\\\\\\\\\\\\\\\

    public static String reverseWords(String s) {
        String str[] = s.trim().split("\\s+");
        StringBuilder newStr = new StringBuilder();

        for(int i = str.length -1; i >= 0; i--){
            newStr.append(str[i]);
            if(i != 0){
                newStr.append(" ");
            }
        }
        return newStr.toString();
    }

    /////////////////////// Excel Sheet Column Title -->'AB' => 28  \\\\\\\\\\\\\\

    public static int titleToNumber(String columnTitle) {
        int ans = 0;

        for(int i = 0; i < columnTitle.length(); i++){
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);

            //ans = ans * 26 + value;
        }
        return ans;
    }


    
 
    ////////////////// Return More Then One DNA Sequence From The Given Array \\\\\\\\\\\\\\\\\\\

    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String , Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(int i = 0; i <= s.length() - 10; i++){
            String str = s.substring(i , i + 10);
            map.put(str , map.getOrDefault(str,0) + 1);

            if(map.get(str) == 2){
                ans.add(str);
            }
        }
        return ans;
    }

    ///////////////// Compaire Version Number \\\\\\\\\\\\\\\\\ 

    public static int compareVersion(String version1, String version2) {
        String [] a = version1.split("\\.");
        String [] b = version2.split("\\.");

        int n = Math.max(a.length , b.length);

        for(int i = 0; i < n; i++){
            int x = 0;
            int y = 0;

            if(i < a.length){
                x = Integer.parseInt(a[i]);
            }

            if(i < b.length){
                y = Integer.parseInt(b[i]);
            }

            if(x < y){
                return -1;
            }
            if(x > y){
                return 1;
            }
        }
        return 0;
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



    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s1, wordDict));

        String s = "abbac";
        System.out.println(longestBalanced(s));

        String str = "the sky is blue";
        System.out.println(reverseWords(str)); 

        String s3 = "AB";
        System.out.println(titleToNumber(s3));

        String s4 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> dna = findRepeatedDnaSequences(s4);

        System.out.println(dna);

        String version1 = "1.2";
        String version2 = "1.10";
        System.out.println(compareVersion(version1, version2));

        String nums[] = {"10", "01"};
        System.out.println(findDifferentBinaryString(nums));

        String s5 = "1111";
        System.out.println(minOperations(s5));

        String s2 = "1100";
        System.out.println(checkOnesSegment(s2));


    }
}
