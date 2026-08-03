import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class week11 {
    ////////////  The k-th Lexicographical String of All Happy Strings of Length n \\\\\\\\\\\\\\
    
    static List<String> list = new ArrayList<>();
    public static String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        backTrack(n , sb);
        if(k > list.size()){
            return "";
        }

        return list.get(k - 1);


    }
    private static void backTrack(int n, StringBuilder sb){
        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }

        char chStr[] = {'a', 'b', 'c'};

        for(char ch : chStr){
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != ch){
                sb.append(ch);

                backTrack(n, sb);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
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

    ////////////////////////// Happy Number \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    public static boolean isHappy(int n) {
        HashSet <Integer> set = new HashSet<>();
        while( n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = getNext(n);
        }
        return true;
    }
    private static int getNext(int n){
        int sum = 0;
        while(n > 0){
            int last = n % 10;
            sum += last * last;
            n = n / 10;
        }
        return sum;
    }

    //////////////////// Count the prime Number \\\\\\\\\\\\\\\\\\\

    public static int countPrimes(int n) {
        int count = 0;
        if(n <= 2){
            return 0;
        }
        
        boolean prime[] = new boolean[n];
        Arrays.fill(prime , true);

        prime[1] = false;
        prime[0] = false;

        for(int i = 2; i * i < n; i++){
            if(prime[i]){
                for(int j = i * i; j < n; j += i){
                    prime[j] = false;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(prime[i]){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int n = 1 , k = 3;
        System.out.println(getHappyString(n, k));

        char [][]grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));

        int n1 = 19;
        System.out.println(isHappy(n1));

        int number = 10;
        System.out.println(countPrimes(number));
    }
}
