import java.util.*;
    
public class Week2 {

    ////// PRINT ARRAY \\\\\\

    public static void printArray(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
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

        for(int i = 0; i< s.length(); i++){
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

    //// Longest Common Prefix ////////
    
    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for(int i = 0; i<first.length(); i++){
            char ch = first.charAt(i);

            for(int j = 1; j<strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }

    /// 3 SUM////
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){

                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
                
            }
            
        }
        return list;
    }
//// 3 sum closest////

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for(int i = 0; i<nums.length-2; i++){
            
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - sum) < Math.abs(target - res)){
                    res = sum;
                }
                if(sum == target){
                    return sum;
                }
                else if (sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }

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

///// 4SUM ////// 

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i<n - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j<n-2;j++){
                if(j > i+1 && nums[j] == nums[j -1]){
                    continue;
                }

                int left = j+1;
                int right = n-1;

                while(left < right){
                    long sum =(long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){

                        res.add(Arrays.asList(nums[i] , nums[j] ,nums[left], nums[right]));

                        while(left < right && nums[left] == nums[left +1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right -1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return res;
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
    
    /////// REMOVE DUBLICATE FROM SORTED ARRAY AND RETURN COUNT  \\\\\\\\\\
    
     public static int removeDuplicates(int[] nums) {
        int i =0;

        for(int j = 1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
    return i+1;
    }

    //// REMOVE ELEMENT NOT EQUAL TO N  AND RETUEN \\\\
    public static int removeElement(int[] nums, int val) {
       int a = 0;

       for(int i = 0; i < nums.length ; i++){
            if(nums[i] != val){
                nums[a] = nums[i];
                a++;
            }
        
       }
       return a; 
    }

    public static void main(String[] args) {
        int num = 12357;
        System.out.println(intToRoman(num));

        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

        String [] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

        int arr1[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr1));

        int arr2[] = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr2, target));

        String s1 = "23";
        System.out.println(letterCombinations(s1));

        int arr3[] = {1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println(fourSum(arr3, target1));

        String s2 = "()";
        System.out.println(isValid(s2));

        int n =3;
        System.out.println(generateParenthesis(n));

        int arr[] = {1,2,2,3,3};
        System.out.println(removeDuplicates(arr));
        //printArray(arr);

        int arr4[] = {3,2,2,3};
        int n1 = 3;
        System.out.println(removeElement(arr4, n1));
        //printArray(arr4);
    }
}

