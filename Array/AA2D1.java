package Array;

public class AA2D1 {
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


    public static void main(String[] args) {
        int[][]grid = {{7,6,3},{6,6,1}};
        int k = 18;
        System.out.println(countSubmatrices(grid, k));

        int matrix[][] = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}
        };
        System.out.println(searchMatrix(matrix, 19));
    }
}
