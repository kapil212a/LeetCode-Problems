import java.util.ArrayList;
import java.util.List;

public class Week5 {

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
        int dp [][] = new int[m][n];

        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m -1][n -1];
    }


    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n , k));

        int n1 = 3, m1 = 7;
        System.out.println(uniquePaths(m1, n1));
    }
}
