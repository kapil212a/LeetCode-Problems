public class week10 {
    /////////////////Concatenation of Consecutive Binary Numbers \\\\\\\\\\\\\\\\\
    public static int concatenatedBinary(int n) {
        long sum = 0;
        long mod = 1000000007;
        for(int i = 1 ; i <= n; i++){
            int val = Integer.toBinaryString(i).length();
            sum = ((sum << val) | i) % mod;
        }
        return (int)sum;
    }

    //////////////////////// Rotate The array from kth element \\\\\\\\\\\\\\\\\\\\\\\

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private static void reverse(int nums[] , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    /////////////////////// Robery in not adjucent house and return max money \\\\\\\\\\\\\\\\\\\\\\\\\

    


    public static void main(String[] args) {
        int n = 3;
        System.out.println(concatenatedBinary(n));

        int arr[] = {-1,-100,3,99};
        int k = 2;
        rotate(arr, k);
        
    }
}
