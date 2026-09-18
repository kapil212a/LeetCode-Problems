package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class String4 {
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

    /////////////////////////// Isomorphic String \\\\\\\\\\\\\\\\\\\\\\\

public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2){
                    return false;
                }
            }
            else{
                map1.put(ch1, ch2);
            }
            if(map2.containsKey(ch2)){
                if(map2.get(ch2) != ch1){
                    return false;
                }
            }
            else{
                map2.put(ch2, ch1);
            }
        }
        
        return true;
    }

    //////////////////// Basic Calculater \\\\\\\\\\\\\\\\\\\

    public static int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                st.push(result);
                st.push(sign);
                
                result = 0;
                sign = 1;
            }
            else if(ch == ')'){
                result += sign * num;
                num = 0;

                int prevSign = st.pop();
                int prevResult = st.pop();

                result = prevResult + prevSign * result;
            }
        }
        result += sign * num;
        return result;
    }

    ///////////// DIFFERENT wAYS TO add Paresnthesis \\\\\\\\\\\\\\

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*'){
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> lPart = diffWaysToCompute(left);
                List<Integer> rPart = diffWaysToCompute(right);

                for(int a : lPart){
                    for(int b : rPart){
                        if(ch == '+'){
                            ans.add(a + b);
                        }
                        else if(ch == '-'){
                            ans.add(a - b);
                        }
                        else{
                            ans.add(a * b);
                        }
                    }
                }
            }
           
        }
        if(ans.isEmpty()){
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }

    ///////////////////  Sun Game \\\\\\\\\\\\\\\\\\\\\\
    
    public static boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;

        int sum1 = 0;
        int sum2 = 0;
        int qSum1 = 0;
        int qSum2 = 0;

        for(int i = 0; i < mid; i++){
            if(num.charAt(i) == '?'){
                qSum1++;
            }
            else{
                sum1 += num.charAt(i) - '0';
            }
        }

        for(int i = mid; i < n; i++){
            if(num.charAt(i) == '?'){
                qSum2++;
            }
            else{
                sum2 += num.charAt(i) - '0';
            }
        }

        int diff = sum1 - sum2;
        int qDiff = qSum2 - qSum1;

        return 2 * diff != qDiff * 9;
    }

    ///////////////// Word Pattern \\\\\\\\\\\\\\\\\\\

    public static  boolean wordPattern(String pattern, String s) {
        
        String arr[] = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = arr[i];

            if(map1.containsKey(ch) && !map1.get(ch).equals(word)){
                return false;
            }
            if(map2.containsKey(word) && map2.get(word) != ch ){
                return false;
            }
            map1.put(ch, word);
            map2.put(word, ch);
        }
        return true;
    }

    //////////////////////// Group the anagram Strings In a list \\\\\\\\\\\\\\\\\\\\\\\\
    public static ArrayList<ArrayList<String>> anagram(String arr[]){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String , Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            String s = arr[i];

            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            s = new String(ch);

            if(!map.containsKey(s)){
                map.put(s, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(s)).add(arr[i]);
  
        }
        return res;
    }


    public static void main(String[] args) {
        String word = "xycdefghij";
        System.out.println(minimumPushes(word));

        String word2 = "xyzxyzxyzxyz";
        System.out.println(minimumPushesII(word2));

         String s = "paper", t = "title";
        System.out.println(isIsomorphic(s,t));  

        String s1 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s1));

        String expression = "2-1-1";
        List<Integer> x = diffWaysToCompute(expression);
        System.out.println(x);

        String num = "5023"; ////////// ?3295???;
        System.out.println(sumGame(num));

        String pattern = "abba", s2 = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s2));

        String arr[] = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> x1 = anagram(arr);
        System.out.println(x1);


    }
}
