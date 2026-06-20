import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Street2 {

    ////////////////// Print 2D Matrix \\\\\\\\\\\\\\\\\

    public static void pritn2dMtrix(int matrix[][]){
        for(int i = 0; i < matrix.length; i++){
            System.out.print("[");
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }System.out.println("]");
        }
    }

    //////////// Angle Between Hands Of Clock \\\\\\\\\\\\\\\\
    
    public static double angleClock(int hour, int minutes) {
        double hourAngle = 30 * hour + 0.5 * minutes;
        double minAngle = 6 * minutes;

        double angle = Math.abs(hourAngle - minAngle);

        return Math.min(angle , 360 - angle);
    }

    //////////////// Minimum Difference Between Highest and Lowest of K Scores \\\\\\\\\\\\\\\\
    
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= nums.length - k ; i++){
            min = Math.min(min,nums[i + k - 1] - nums[i]);
        }
        return min;
    }

    //////////////////// Minimum Absolute Difference in given Array\\\\\\\\\\\\\\\\\
    
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++){
            min = Math.min(min, arr[i] - arr[i - 1]);
        }

        List <List<Integer>> list = new ArrayList<>();

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] == min){
                list.add(Arrays.asList(arr[i -1], arr[i]));
            }
        }
        return list;
    }

    ////////////// Find the Highest Atitude \\\\\\\\\\\\\\\\\\

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;

        for(int x : gain){
            curr += x;
            max = Math.max(max, curr);
        }
        return max;
    }

    ////return the minimum number of operations required to convert word1 to word2 \\\\\\\\\

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        } 
        for(int j = 0; j <= m; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j -1];
                }
                else{
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[n][m];
    }


    ////////////// Set Matrix To Zero If Any Row And Col Contains Zero \\\\\\\\\\\\\\

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] zeroRow = new boolean[n];
        boolean[] zeroCol = new boolean[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(zeroRow[i]){
                for(int j = 0; j < m; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < m; j++){
            if(zeroCol[j]){
                for(int i = 0; i < n; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /////////////// Search In 2D Matrix \\\\\\\\\\\\\\\\

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];

            if(value == target){
                return true;
            }
            if(value < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;
        System.out.println(angleClock(hour, minutes));

        int nums[] = {9,4,1,7};
        int k = 4;
        System.out.println(minimumDifference(nums, k));

        int arr[] = {3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> list = minimumAbsDifference(arr);
        System.out.println(list);

        int gain[] = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));

        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));

        int matrix[][] = {{0,1,2,0},
                          {3,4,5,2},
                          {1,3,1,5}};
        setZeroes(matrix);
        pritn2dMtrix(matrix);
    }

}
