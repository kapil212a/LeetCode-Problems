import java.util.*;

public class week13 {
    ///////Count Submatrices with Top-Left Element and Sum Less Than k\\\\\\\
    
    public static int countSubmatrices(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;

        for(int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                if(i > 0){
                    grid[i][j] += grid[i - 1][j];
                }
                if(j > 0){
                    grid[i][j] += grid[i][j - 1];
                }

                if(i > 0 && j > 0){
                    grid[i][j] -= grid[i - 1][j - 1];
                }

                if(grid[i][j] <= k){
                    ans++;
                }
            }
        }
        return ans;
    }

    //////////////////// Basic Calculater \\\\\\\\\\\\\\\\\\\

     public static int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                st.push(result);
                st.push(sign);
                
                result = 0;
                sign = 1;
            }
            else if(ch == ')'){
                result += sign * num;
                num = 0;

                int prevSign = st.pop();
                int prevResult = st.pop();

                result = prevResult + prevSign * result;
            }
        }
        result += sign * num;
        return result;
    }

    ////////////////// Add Digit up to single digit  \\\\\\\\\\\\\\\\\\\
 
    public static int addDigits(int num) {
        int add = digitSum(num);
        if(add >= 10){
            return addDigits(add);
        }else{
             return add;
        }
    }

    private static int digitSum(int n){
        int sum = 0;
        while(n > 0){
            int last = n % 10;
            sum += last;
            n = n / 10;
        }
        return sum;
    }

    //////////////////// 3 Smallest Sum in Array \\\\\\\\\\\\\\\\

    public static int smallest3Sum(int arr[], int target){
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        for(int i = 0; i < n - 2; i++){

            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum > target){
                    count += right - left;
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }

    //////////////////// Single Number III Once At A time In Array\\\\\\\\\\\\\\\\\\\

    public static int[] singleNumber(int[] nums) {
        int []count = new int[2];
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int j = 0;
        
        for(int num : map.keySet()){
            if(map.get(num) == 1){
                count[j++] = num;
            }
        }
        return count;
    }

    ////////////////// Cenema Seat Allowcation \\\\\\\\\\\\\\\\\\\\

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] num : reservedSeats){
            int row = num[0];
            int seat = num[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << seat));
        }
        int ans = (n - map.size()) * 2;
       
        for(int mask : map.values()){
            boolean left = (mask & 60) == 0;
            boolean mid = (mask & 240) == 0;
            boolean right = (mask & 960) == 0;

            if(left && right){
                ans += 2;
            }
        
            else if(left || mid || right){
                ans += 1;
            }
            
        }
        return ans;
    }

    ////////////////////// Distribute Element into 2 part \\\\\\\\\\\\\\\\\\\\

    public static int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int res[] = new int[nums.length];

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < nums.length; i++){
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }

        }
        int idx = 0;
        for(int num : arr1){
            res[idx++] = num;
        }
        for(int num : arr2){
            res[idx++] = num;
        }
        return res;
    }

 
    ////////////////////Is the number is Power Of 2 \\\\\\\\\\\\\\\\\\\\\\\\

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    public static void main(String[] args) {
        int[][]grid = {{7,6,3},{6,6,1}};
        int k = 18;
        System.out.println(countSubmatrices(grid, k));

        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));

        int digit = 56;
        System.out.println(addDigits(digit));

        int arr[] = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(smallest3Sum(arr, target));

        int nums[] = {1,2,1,3,2,5};
        System.out.println(singleNumber(nums));

        int n = 3;
        int [][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        System.out.println(maxNumberOfFamilies(n, reservedSeats));

        int arr1[] = {5,4,3,8};
        System.out.println(resultArray(arr1));

        int n1 = 16;
        System.out.println(isPowerOfTwo(n1));

    }
    
}
