import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    //////////////////// Count the prime Number   \\\\\\\\\\\\\\\\\\\

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

    ///////////////////// Finding Missing elements in List \\\\\\\\\\\\\\\\\\

    public static List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int small = nums[0];
        int large = nums[nums.length - 1];

        HashSet<Integer> set = new HashSet<>();

         for(int i = 0; i < nums.length; i++){
           set.add(nums[i]);
        }
        
        for(int i = small; i <= large; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
       
        return ans;
    }

/////////////////////////// Isomorphic String \\\\\\\\\\\\\\\\\\\\\\\

public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1)){
                if(map1.get(ch1) != ch2){
                    return false;
                }
            }
            else{
                map1.put(ch1, ch2);
            }
            if(map2.containsKey(ch2)){
                if(map2.get(ch2) != ch1){
                    return false;
                }
            }
            else{
                map2.put(ch2, ch1);
            }
        }
        
        return true;
    }

    //////////////////// Minimum Size Subarray \\\\\\\\\\\\\\\\\\\\\\
    
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while(sum >= target){
                min = Math.min(min, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    ///////////////////////// House Robery II \\\\\\\\\\\\\\\\\\\\\

    public static int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }
        int sec = robing(nums, 0, n -2);
        int first = robing(nums, 1, n-1);
        

        return Math.max(first, sec);
    }

    private static int robing(int nums[], int start, int end){
        int prev = 0;
        int curr = 0;

        for(int i = start; i <= end; i++){
            int sum = prev + nums[i];
            int skip = curr;

            int high = Math.max(sum, skip);

            prev = curr;
            curr = high;
        }
        return curr;
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

        int num[] = {1,2,5};
        List<Integer> ans =  findMissingElements(num);
        System.out.println(ans);

        String s = "paper", t = "title";
        System.out.println(isIsomorphic(s,t));  

        int arr[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(number, arr));

        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
