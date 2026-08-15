import java.util.Stack;

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



    public static void main(String[] args) {
        int[][]grid = {{7,6,3},{6,6,1}};
        int k = 18;
        System.out.println(countSubmatrices(grid, k));
    }
    
}
