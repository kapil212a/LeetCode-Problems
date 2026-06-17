import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Week5 {

    ////////// PRINT 1D ARRAYS \\\\\\\\\\\\\\\

    public static void printArray(int arr[]){
        System.out.print("[");
        for(int i : arr){
            System.out.print(i +" ");
        }System.out.println("]");
    }

    //////////// PERMUTATION SEQUENCE \\\\\\\\\\\\

    public static String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();

        int fact = 1;
        for(int i = 1; i < n; i++){
            fact *= i;
        }
        for(int i = 1; i <= n; i++){
            num.add(i);
        }
        k = k - 1;

        StringBuilder str = new StringBuilder();
        while(num.size() > 0){
            int idx = k / fact;

            str.append(num.get(idx));

            num.remove(idx);

            if(num.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / num.size();
        }
        return str.toString();
    }

    ////////// FIND UNIQE PATH IN M * N  GRID \\\\\\\\\\\\\
    
    public static int uniquePaths(int m, int n) {
        // int dp [][] = new int[m][n];

        // for(int i = 0; i < n; i++){
        //     dp[0][i] = 1;
        // }
        // for(int i = 0; i < m; i++){
        //     dp[i][0] = 1;
        // }

        // for(int i = 1; i < m; i++){
        //     for(int j = 1; j < n; j++){
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }
        // return dp[m -1][n -1];

        int dp[] = new int [n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    ///////////////// PLUS ONE AT THE LAST OF DIGIT IN ARRAYS \\\\\\\\\\\\

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n -1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int [] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    ///////// ADD BINARY \\\\\\\\\\\\\

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            ans.append(sum % 2);
            carry = sum /2;
        }
        return ans.reverse().toString();
    }

    ///////////// CLACULATE SQURE ROOT VALUE \\\\\\\\\\\\\\\\

    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        int ans = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long sqr = (long) mid * mid;
            if(sqr == x){
                return mid;
            }

            if(sqr < x){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }

    ///////////// CLIMBING STAIR \\\\\\\\\\\\\\\\

    public static int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int oneStep = 2;
        int twoStep = 1;

        for(int i = 3; i <= n; i++){
            int curr = oneStep + twoStep;

            twoStep = oneStep;
            oneStep = curr;
        }
        return oneStep;
    }
    //////////////// Simplify Path \\\\\\\\\\\\\\\\

    public static String simplifyPath(String path) {
        Stack<String> st= new Stack<>();

        String [] folder = path.split("/");

        for(String str : folder){
            if(str.equals("") || str.equals(".")){
                continue;
            }
            if(str.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(str);
            }

        }
        StringBuilder ans = new StringBuilder();

        for(String str : st){
            ans.append("/");
            ans.append(str);
        }
        if(ans.length() == 0){
            return "/";
        }
        else{
            return ans.toString();
        }
    }

    ///////////////  Minimize Maximum Pair Sum in Array \\\\\\\\\\\\\

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;

        int ans = 0;

        while(i < j){
            int sum = nums[i] + nums[j];
            ans = Math.max(ans ,sum);

            i++;
            j--;
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n , k));

        int n1 = 3, m1 = 7;
        System.out.println(uniquePaths(m1, n1));

        int digits[] = {4,3,2,1};
        printArray(plusOne(digits));

        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));

        int x = 10;
        System.out.println(mySqrt(x));

        int n2 = 5;
        System.out.println(climbStairs(n2));

        String path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));

        int nums5[] = {3,5,2,3};
        System.out.println(minPairSum(nums5));
        
    }
}
