import java.util.ArrayList;
import java.util.List;

public class Week14 {
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

    ///////////Remove Min And Max From Array \\\\\\\\\\\\\
    /// 
    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < nums[min]){
                min = i;
            }

            if(nums[i] > nums[max]){
                max = i;
            }
        }
        if(min > max){
            int temp = min;
            min = max;
            max = temp;
        }

        int front = max + 1;
        int back = n - min;

        int both = (min + 1) + (n - max);

        return Math.min(front, Math.min(back, both));
    }


    /////////////// Product Of Array Except Self \\\\\\\\\\\\\\\\\\\\\\\

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int j = 1;

        for(int i = 0; i < n; i++){
            ans[i] = j;
            j = j * nums[i];
        }

        int k = 1;
        for(int i = n - 1; i >= 0; i--){
            ans[i] *= k;
            k = k * nums[i];
        }
        return ans;
    }

    ////////////////// Construct Uniform Parity Array II \\\\\\\\\\\\\\\

    public static boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for(int x : nums1){
            min = Math.min(min, x);
        }
        if(min % 2 == 1){
            return true;
        }
        for(int x : nums1){
            if(x % 2 == 1){
                return false;
            }
        }
        return true;
    }

    /////////////////// Search In 2D matrix \\\\\\\\\\\\\\\\\\\\

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    ///////////// dIFFERENT wAYS TO add Paresnthesis \\\\\\\\\\\\\\

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

    ///////////////// Smallest Stable Index I \\\\\\\\\\\\\\\\\

    public static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n];

        prefix[n - 1] = nums[n -1];

        for(int i = n - 2; i >= 0; i--){
            prefix[i] = Math.min(nums[i], prefix[i + 1]);
        }

        int max = nums[0];

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            int diff = max - prefix[i];

            if(diff <= k){
                return i;
            }
        }
        return -1;

    }

    //////////////// Find Ugly Number \\\\\\\\\\\\\\\\\\\\\
    
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        while(n % 2 == 0){
            n /= 2;
        }
        while(n % 3 == 0){
            n /= 3;
        }
        while(n % 5 == 0){
            n /= 5;
        }
        return n == 1;
    }


    public static void main(String[] args) {
        String num = "5023"; ////////// ?3295???;
        System.err.println(sumGame(num));

        int arr1[] = {2,5,6,0,0,1,2};
        minimumDeletions(arr1);

        int arr2[] = {1, 2, 3, 4};
        System.out.println(productExceptSelf(arr2));

        int arr3[] = {1,4,7};
        System.out.println(uniformArray(arr3));

        int matrix[][] = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}
        };
        System.out.println(searchMatrix(matrix, 19));

        String expression = "2-1-1";
        List<Integer> x = diffWaysToCompute(expression);
        System.out.println(x);

        int arr4[] = {5,0,1,4};
        int k = 3;
        System.out.println(firstStableIndex(arr4, k));

        
    }

}
