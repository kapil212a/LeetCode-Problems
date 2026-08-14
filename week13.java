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


    public static void main(String[] args) {
        int[][]grid = {{7,6,3},{6,6,1}};
        int k = 18;
        System.out.println(countSubmatrices(grid, k));
    }
    
}
