package String;

import java.util.*;

public class String5 {
    //////////////////// Reverse The Degree Of String \\\\\\\\\\\\\
    public static int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int val = 'z' - ch + 1;
            sum += val * (i + 1);
        }
        return sum;
    }

    ////////////////// Furthest Point From Origin /\\\\\\\\\'\\\\\
    public static  int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int empty = 0;

        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);

            if(ch == 'L'){
                l++;
            }
            else if(ch == 'R'){
                r++;
            }
            else if(ch == '_'){
                empty++;
            }
        }
        return Math.abs(l - r) + empty;
    }

    ////////////////// Evaluate the Bracket Pairs of a String \\\\\\\\\\\\\\

    public static String evaluate(String s, List<List<String>> knowledge) {
        HashMap <String , String> map = new HashMap<>();

        for(List<String> pair : knowledge){
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '('){
                ans.append(s.charAt(i));
                continue;
            }

            int j = i + 1;

            while(s.charAt(j) != ')'){
                j++;
            }
            String sub = s.substring(i + 1, j);
            if(map.containsKey(sub)){
                ans.append(map.get(sub));
            }
            else{
                ans.append('?');
            }
            i = j;

        }
        return ans.toString();
    }

    ////////////////////// Reverse Substrings Between Each Pair of Parentheses \\\\\\\\\\\\\
    
    public static String reverseParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Stack <StringBuilder> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ans);
                ans = new StringBuilder();
            }
            else if(ch == ')'){
                ans.reverse();
                StringBuilder prev = st.pop();
                prev.append(ans);
                ans = prev;
            }
            else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }



    public static void main(String[] args) {
        String s = "zaza";
        System.out.println(reverseDegree(s));

        String moves = "L_RL__R";
        System.out.println(furthestDistanceFromOrigin(moves));

        String s1 = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        // {{"name","bob"},{"age","two"}};
        knowledge.add(Arrays.asList("name","bob"));
        knowledge.add(Arrays.asList("age","two"));
        System.out.println(evaluate(s1, knowledge));

        String s2 = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s2));

    }
}
