package Array;

import java.util.Arrays;

public class Array2 {

     /////// PRINT ARRAY \\\\\\\\
    public static void printArr(int [] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }


    ///// FIND INSERTION POINT IN THE ARRAY \\\\\\\

    public static int searchInsert(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;

            }
            else{
                right = mid - 1;
            }
        }
        return left;
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

    //////// DESTOYING AESTROIDS \\\\\\
    
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long curr = mass;
        for(int i : asteroids){
            if(i > curr){
                return false;
            }
            curr += i;
        }
        return true;
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

    ////////// JUMP GAME \\\\\\\\\\\\

    public static boolean canJump(int[] nums) {
        int fart = 0;

        for(int i = 0; i< nums.length; i++){

            if(i > fart){
                return false;
            }

            fart = Math.max(fart, i + nums[i]);

            if(fart >= nums.length - 1){
                return true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int nums2 [] = {1,3,4,6};
        int target1 = 5;
        System.out.println(searchInsert(nums2, target1));

        int nums1[] = {5,7,7,8,8,10};
        int target = 8;
        int res[] = searchRange(nums1, target);
        printArr(res);

        int nums[] = {1,2,3};
        nextPermutation(nums);
        printArr(nums);

        int arr[] = {10,12,15,25};
        System.out.println(minElement(arr));
        printArr(arr);

        int mass  = 10;
        int aestroids[] = {3,9,19,5,21};
        System.out.println(asteroidsDestroyed(mass, aestroids));

        int dividend = 100;
        int divisor = 15;
        System.out.println(divide(dividend, divisor));

         int nums3[] = {2,3,1,1,4};
        System.out.println(canJump(nums3));
    }
}
