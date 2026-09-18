package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Array5 {
    public static void printArr(int arr[]){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + " ");
        }System.out.println("]");
    }

    ////////////////// Best Time to Buy and Sell Stock\\\\\\\\\\\\\\\\\\\
    
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;

            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    ////////////////// Best Time to Buy and Sell Stock\\\\\\\\\\\\\\\\\\\

    public static int maxProfitII(int[] prices) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

     //////////////////FInd the largets element in O(logn) \\\\\\

    public static int findPeakElement(int[] nums) {
        int left = 0 , right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) /2;

            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    ///////////////////// Find Minimum in Rotated Sorted Arrays II \\\\\\\\\\\\\\\\

    public static int findMinII(int[] nums) {
        int left = 0 , right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else if(nums[mid] < nums[right]){
                right = mid;
            }
            else{
                right--;
            }
        }
        return nums[left];
    }

     ////////////////// Least Number In rotated Sorted Array \\\\\\\\\\\\\\\\
    
    public static int findMin(int[] nums) {
        int left = 0 , right = nums.length -1;

        while(left < right){
            int mid = left + (right - left) /2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }

    /////////////////////// Maximum Product SubArray \\\\\\\\\\\\\\\\\

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i] , min * nums[i]);
            ans = Math.max(ans , max);
        }
        return ans;
    }

    //////////////////////// Evaluate Reverse Polish Notation \\\\\\\\\\\\\\\\\\\

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String str : tokens){
            if(str.equals("+")){
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
            }
            else if(str.equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            }
            else if(str.equals("*")){
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
            }
            else if(str.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a / b);
            }
            else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }

    ////////////////// Rank Transform Of an Array \\\\\\\\\\\\\\\

    public static int[] arrayRankTransform(int[] arr) {
        int [] temp = new int[arr.length];

        int newTemp[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            newTemp[i] = arr[i];
        }

        Arrays.sort(newTemp);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : newTemp){
            if(!map.containsKey(num)){
                map.put(num , rank);
                rank++;
            }
        }

        for(int i = 0; i < arr.length; i++){
            temp[i] = map.get(arr[i]);
        }
        return temp;
    }
    


    /////////////// Longest Consecutive Sequence \\\\\\\\\\\\\\\
    
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();

        for(int num : nums){
            ans.add(num);
        }
        int sum = 0;

        for(int num : ans){
            if(!ans.contains(num - 1)){
                int curr = num;
                int len = 1;

                while(ans.contains(curr + 1)){
                    curr++;
                    len++;
                }
                sum = Math.max(sum , len);
            }
        }
        return sum;
    }

    ///////////////////// Maximum Product Of Two Element In Array \\\\\\\\\\\\\\\\\\\\\\\\\\

    public static int maxProduct1(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        for(int num : nums){
            if(num > max1){
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

     /////////////////////////Largest Number From combining all Number In arrays \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static String largestNumber(int[] nums) {
        String arr[] = new String[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a , b) -> (b + a).compareTo(a + b));

        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder ans = new StringBuilder();

        for(String s : arr){
            ans.append(s);
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
       System.out.println(maxProfit(prices)); 
       
       System.out.println(maxProfitII(prices));

       int ele[] = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(ele));

        int arr3[] = {2,2,2,0,1};
        System.out.println(findMinII(arr3));

        int arr2[] = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr2));

        int arr1[] = {2,3,-2,4};
        System.out.println(maxProduct(arr1));

        String []tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

        int arr[] = {40, 10, 20, 30};
        printArr(arrayRankTransform(arr));
        
        int num[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));

        int arr4[] = {3,4,5,2};
        System.out.println(maxProduct1(arr4));

        int nums2[] = {3,30,34,5,9};
        System.out.println(largestNumber(nums2));
    }
}
