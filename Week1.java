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

    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5};
        int target = 5;
        int start = 3;
        System.out.println(getMinDistance(nums , target , start));

        String s = "abccbabac";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
