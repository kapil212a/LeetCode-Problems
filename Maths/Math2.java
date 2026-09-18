package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Math2 {
    ///////////////////////// Factorial Trilling Zeros \\\\\\\\\\\\\\\\\\\

    public static int trailingZeroes(int n) {
        int count = 0;
        while(n > 0){
            n = n / 5;
            count += n;
        }
        return count;
    }

    /////////////////////// Excel Sheet Column Title --> 28 => 'AB' \\\\\\\\\\\\\\

    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while(columnNumber > 0){
            columnNumber--;

            int rem = columnNumber % 26;
            char ch = (char) ('A' + rem);
            ans.append(ch);
            columnNumber = columnNumber / 26;
        }
        return ans.reverse().toString();
    }

    /////////////////Concatenation of Consecutive Binary Numbers \\\\\\\\\\\\\\\\\
    public static int concatenatedBinary(int n) {
        long sum = 0;
        long mod = 1000000007;
        for(int i = 1 ; i <= n; i++){
            int val = Integer.toBinaryString(i).length();
            sum = ((sum << val) | i) % mod;
        }
        return (int)sum;
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

    //////////// Overlapping Rectangular Area \\\\\\\\\\\\\\\\

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int width = Math.min(ax2,bx2) - Math.max(ax1, bx1);
        int height = Math.min(ay2, by2) - Math.max(ay1,by1);

        int overlap = 0;

        if(width > 0 && height > 0){
            overlap = width * height;
        }
        return area1 + area2 - overlap;
    }

    ///////////////// Combination Sum III \\\\\\\\\\\\\\\\

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        //List<Integer> sum = new ArrayList<>();

        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private static void solve(int start, int k, int target, List<Integer> sum, List<List<Integer>>ans){
        if(sum.size() == k){
            if(target == 0){
                ans.add(new ArrayList(sum));
            }
            return;
        }

        for(int i = start; i <= 9; i++){
            sum.add(i);
            solve(i + 1, k, target - i, sum, ans);
            sum.remove(sum.size() - 1);
        }
    }

    ///////////////// Check Divisibility by Digit Sum and Product \\\\\\\\\\\

    public static boolean checkDivisibility(int n) {
        int num = n;

        int sum = 0;
        int product = 1;
        while(num > 0){
            int last = num % 10;
            sum = sum + last;
            product = product * last;
            num = num / 10;
        }
        int total = sum + product;
        if(n % total == 0){
            return true;
        }
        return false;
    }

    ////////////////////Is the number is Power Of 2 \\\\\\\\\\\\\\\\\\\\\\\\

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    public static void main(String[] args) {
        int n = 23;
        System.out.println(trailingZeroes(n));

        int columnNumber = 28;
        System.out.println(convertToTitle(columnNumber));

        int n1 = 3;
        System.out.println(concatenatedBinary(n1));

        int number = 10;
        System.out.println(countPrimes(number));

        int n2 = 1 , k = 3;
        System.out.println(getHappyString(n2, k));

        int n3 = 19;
        System.out.println(isHappy(n3));

        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
       System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));

       int k1 = 3, n5 = 7;
       List<List<Integer>> ans = combinationSum3(k1, n5);
       System.out.println(ans);

        int n4 = 99;
        System.out.println(checkDivisibility(n4));

        int n6 = 16;
        System.out.println(isPowerOfTwo(n6));


    }
}
