import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class week3 {
    /////// PRINT ARRSY \\\\\\\\

    public static void printArr(int [] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
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

    ///// DIVIDE TWO INTEGER WITHOUT USING /, * , OPERATOR \\\\\\\

    public static int divide(int dividend, int divisor) {
        boolean neg = (dividend < 0) ^ (divisor < 0);

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long)divisor);

        int ans = 0;
        while(dvd >= dvs){
            long temp = dvs;
            int mul = 1;

            while(dvd >= (temp << 1)){
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            ans += mul;
        }
        if(neg){
            return -ans;
        }
        else{
            return ans;
        }
    }

    ///// MINIMUM ELEMENT AFTER REPLACEMENT WITH DIGIT SUM IN ARRAY \\\\\\

    public static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            int sum = 0;

            while(num > 0){
                sum +=  num % 10;
                num = num / 10;
            }
            min = Math.min(min , sum);
        }
        return min;
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
        for(int i = 0; i<= s.length() - windowSize; i++){

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
    ////// NEXT PERMUTATION \\\\\\

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            reverse(nums , 0, n-1);
            return;
        }

        for(int i = n-1; i > idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums , i , idx);
                break;
            }
        }
        reverse(nums , idx + 1, n-1);
    }
    public static void swap(int nums[] , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int nums[] , int start , int end){
        while(start < end){
            swap(nums , start , end);
            start++;
            end--;
        }
    }

    ////// FIND THE FIRST AND LAST ELEMENT IN THE GIVEN ARRAY \\\\\\

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums , target);
        int last = findLast(nums , target);

        return new int []{first , last};
    }

    private static int findFirst(int nums[] , int target){
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                ans = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }

    private static int findLast(int nums[] , int target){
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                ans = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));

        int dividend = 100;
        int divisor = 15;
        System.out.println(divide(dividend, divisor));

        int arr[] = {10,12,15,25};
        System.out.println(minElement(arr));
        printArr(arr);

        String s = "barfoothefoobarman";
        String words[] = {"foo","bar"};
        System.out.println(findSubstring(s, words));

        int nums[] = {1,2,3};
        nextPermutation(nums);
        printArr(nums);    
    }
}
