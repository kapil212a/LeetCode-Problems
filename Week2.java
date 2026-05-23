import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week2 {
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
    }
}

