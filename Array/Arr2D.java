package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Arr2D {
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
    
    //////////// MERGE INTERVALS \\\\\\\\\\\\\\\\ 

     public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][];
        }
        Arrays.sort(intervals, (a,b) ->a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int[] curr = intervals[0];
        res.add(curr);

        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];

            if(next[0] <= curr[1]){
                curr[1] = Math.max(curr[1] , next[1]);
            }
            else{
                curr = next;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /////////// GENERATE SPIRAL MATRIX FROM SIZE \\\\\\\\\\\\\\

    public static int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];

        int top = 0;
        int bottom = n -1;

        int left = 0;
        int right = n -1;

        int num = 1;
        int target = n * n;

        while(num <= target){
            for(int i = left; i <= right && num <= target; i++){
                matrix[top][i] = num++;
            }
            top++;

            for(int i = top; i <= bottom && num <= target; i++){
                matrix[i][right] = num++;
            }
            right--;

            for(int i = right; i >= left && num <= target; i--){
                matrix[bottom][i] = num++;
            }
            bottom--;

            for(int i = bottom; i >= top && num <= target; i--){
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }

    ///////// VALID SUDOKU \\\\\\\\
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> map = new HashSet<>();
            
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];

                if(ch != '.'){
                    if(map.contains(ch)){
                        return false;
                    }
                    map.add(ch);
                }
            }
        }
        for(int i = 0;i < 9; i++){
            HashSet<Character> map = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char ch = board[j][i];

                if(ch != '.'){
                    if(map.contains(ch)){
                        return false;
                    }
                    map.add(ch);
                }
            }
        }
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){
                HashSet<Character> set = new HashSet<>();

                for(int i =row; i< row + 3; i++){
                    for(int j = col; j< col + 3; j++){

                        char ch = board[i][j];

                        if(ch != '.'){
                            if(set.contains(ch)){
                                return false;
                            }
                            set.add(ch);
                        }
                    }
                }
            }
        }
        return true;
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

    
    ///////////////// Remove covered Intervals \\\\\\\\\\\\\\\\\

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a, b) ->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int max = 0;

        for(int[] num : intervals){
            if(num[1] > max){
                count++;
                max = num[1];
            }
        }
        return count;
    }

    /////////////////// Spacial Position In Binary Matrix \\\\\\\\\\\\\\\\\\\\\\

    public static int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int row [] = new int[n];
        int col[] = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    count++;
                }
            }
        }
        return count; 
    }

    ////////////////// Number Of Island in Matrix \\\\\\\\\\\\\\\\\\\\\\\\\

    public static int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
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


    public static void main(String[] args) {
        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        int x[][] = merge(intervals);
        print2d(x);

        int n = 3;
        print2d(generateMatrix(n));

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));

        int matrix1[][] = {
                            {1,2,3},
                            {4,5,6},
                            {7,8,9},
                        };
        System.out.println(spiralOrder(matrix1));

        int matrix[][] = {
                         {5,1,9,11},
                         {2,4,8,10},
                         {13,3,6,7},
                         {15,14,12,16}
                      };
        rotate(matrix);
        print2d(matrix);

        int interval [][] = {{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(interval));

        int mat[][] = {
            {1,0,0},
            {0,0,1},
            {1,0,0}
        };
        System.out.println(numSpecial(mat));

        char [][]grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));

        int n1 = 3;
        int [][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        System.out.println(maxNumberOfFamilies(n1, reservedSeats));


    }
    
}
