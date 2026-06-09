import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class week4 {
    /////////// PRINT 2D MATRIX \\\\\\\\\
    public static void print2d(int matrix[][]){
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    /////////// EARLIER FINISH TIME OF WATER AND LAND \\\\\\\\\
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i< landStartTime.length; i++){
            int landFinish = landStartTime[i] + landDuration[i];

            for(int j = 0; j < waterStartTime.length; j++){
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finish = waterStart + waterDuration[j];

                ans = Math.min(ans, finish);
            }
        }

        for(int i = 0; i < waterStartTime.length; i++){
            int waterFinish = waterStartTime[i] + waterDuration[i];

            for(int j = 0; j < landStartTime.length; j++){
                int landStart = Math.max(waterFinish, landStartTime[j]);
                int finish = landStart + landDuration[j];

                ans = Math.min(ans, finish);
            }
        }
        return ans;
    }

    //////// FIRST MISSING POSITIVE NUMBER \\\\\\\\\

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        int i = 0;

        while(i < n){
            int correct = nums[i] - 1;

            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }
        for(i = 0; i < n; i++){
            if(nums[i] != i +1){
                return i + 1;
            }
        }
        return n + 1;
    }

    //////// JUMP GAME II \\\\\\\\

    public static int jump(int[] nums) {
        int jump = 0;
        int curr = 0;
        int farth = 0;

        for(int i = 0; i < nums.length - 1; i++){
            farth = Math.max(farth , i + nums[i]);
            if(i == curr){
                jump++;
                curr = farth;
            }
        }
        return jump;
    }

    ////////// PERMUTATION \\\\\\\\\\

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(0 , nums,ans);

        return ans;
    }
    private static void solve(int idx , int [] nums , List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        for(int i = idx; i < nums.length; i++){
            swap(nums , idx, i);
            solve(idx + 1 , nums , ans);
            swap(nums , idx, i);
        }
    }
    private static void swap(int nums[] , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /////////// ROTATE IMAGE OR MATRIX \\\\\\\\\\\\\
     
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        ///// TRANSPOSE OF MATRIX
        for(int i = 0;i < n; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        ////// REVERSE THE ROW
        for(int i = 0; i < n; i++){
            int left = 0;
            int right = n - 1;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    /////////// GROUP  ANAGRAM OF STRING \\\\\\\\\

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String> > map = new HashMap<>();

        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /////////// SPIRAL MATRIX \\\\\\\\\\\

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        while(top <= bottom && left <= right){

            for(int col = left; col <= right; col++){
                ans.add(matrix[top][col]);
            }
            top++;

            for(int row = top; row <= bottom; row++){
                ans.add(matrix[row][right]);
            }
            right--;

            if(top <= bottom){
                for(int col = right; col >= left; col--){
                    ans.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if(left <= right){
                for(int row = bottom; row >= top; row--){
                    ans.add(matrix[row][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       int landStartTime[] = {2,8}, landDuration[] = {4,1};
       int waterStartTime [] = {6}, waterDuration[] = {3};
       System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));

       int nums[] = {7,8,9,11,12};
       System.out.println(firstMissingPositive(nums));

        int nums1[] = {2,3,1,1,4};
       System.out.println(jump(nums1));

       int nums2[] = {1,2,3};
       System.out.println(permute(nums2));

       int matrix[][] = {
                         {5,1,9,11},
                         {2,4,8,10},
                         {13,3,6,7},
                         {15,14,12,16}
                      };
        rotate(matrix);
        print2d(matrix);

        String str[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));


        int matrix1[][] = {
                            {1,2,3},
                            {4,5,6},
                            {7,8,9},
                        };
        System.out.println(spiralOrder(matrix1));
    }
}
