package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class String1 {
    //////////// String TO Integer (Atoi) \\\\\\
    
    public static int myAtoi(String s) {
        s = s.trim();

        if(s.length() == 0){
            return 0;
        }

        int sign = 1;
        int indx = 0;

        if(s.charAt(0) == '-'){
            sign = -1;
            indx++;
        }
        else if(s.charAt(0) == '+'){
            indx++;
        }

        int num = 0;
        while(indx < s.length() && Character.isDigit(s.charAt(indx))){
            int digit = s.charAt(indx) - '0';
            
            if(num > Integer.MAX_VALUE /10 || (num == Integer.MAX_VALUE / 10 && digit > 7)){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            num = num * 10 + digit;
            indx++;
        }
        return num * sign;
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

    /////Longest Palindromic Substring//////

    public static String longestPalindrome(String s) {
        int start = 0 , end = 0;
        
        for(int i = 0; i < s.length(); i++){

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

    ///// LENGTH Longest Substring Without Repeating Characters \\\\\\\

    public static int lengthOfLongestSubstring(String s) {
        Map <Character , Integer> map = new HashMap<>();
        int left = 0 ,length = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                int x = map.get(ch) + 1;
                
                left = Math.max(left , x);
            }

            map.put(ch , i);
            length = Math.max(length , i - left + 1);
        }
        System.out.println(map);
        return length;
    }

    //// Roman To Integer /////
    
    public static int value(char ch){
        if(ch == 'I') return 1;
        if(ch == 'V') return 5;
        if(ch == 'X') return 10;
        if(ch == 'L') return 50;
        if(ch == 'C') return 100;
        if(ch == 'D') return 500;
        return 1000;
    }

    
    public static int romanToInt(String s) {
        int total = 0;

        for(int i = 0; i < s.length(); i++){
            int curr = value(s.charAt(i));

            if(i+1 < s.length() && curr < value(s.charAt(i+1))){
                total = total - curr;
            }
            else{
                total = total + curr;
            }
        }
        return total;
    }

    ////// Integer To Roman//////
    
    public static String intToRoman(int num) {
        int [] value = {
                        1000,900,500,
                        400,100,90,50,
                        40,10,9,5,4,1
                    };

        String [] symbol = {
                            "M", "CM", "D", "CD",
                            "C", "XC", "L", "XL", 
                            "X", "IX", "V", "IV", "I"
                        }; 

        StringBuilder res = new StringBuilder();

        for(int i = 0; i<value.length; i++){
            while(num >= value[i]){
                res.append(symbol[i]);

                num = num - value[i];
            }
        }
        return res.toString();
    }

    ///////// Generate Parenthesis \\\\\\\\
    
    static List<String> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        backtrack("",0,0,n);
        return result;
    }
    public static void backtrack(String curr , int open , int close , int n){
        if(curr.length() == n * 2){
            result.add(curr);
            return;
        }
        if(open < n){
            backtrack(curr + "(" , open +1 , close , n);
        }
        if(close < open){
            backtrack(curr + ")" , open , close + 1 , n);
        }
    }
    
    //// valid Parenthesis ////
    
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if((ch == ')' && top != '(') ||
                  (ch == '}' && top != '{') ||
                  (ch == ']' && top != '[')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }


    public static void main(String[] args) {
        String s4 = "-042ab125";
        System.err.println(myAtoi(s4));

        String s3 = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s3, numRows));

        String s1 = "babad";
        System.out.println(longestPalindrome(s1));

        String s = "abcdcbabac";
        System.out.println(lengthOfLongestSubstring(s));

        String s2 = "MCMXCIV";
        System.out.println(romanToInt(s2));

        int num = 12357;
        System.out.println(intToRoman(num));

        int n =3;
        System.out.println(generateParenthesis(n));

        String s5 = "()";
        System.out.println(isValid(s5));


    }
}
