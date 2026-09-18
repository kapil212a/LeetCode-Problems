package Maths;

public class Math3 {
    ////////////////// Add Digit up to single digit  \\\\\\\\\\\\\\\\\\\
 
    public static int addDigits(int num) {
        int add = digitSum(num);
        if(add >= 10){
            return addDigits(add);
        }else{
             return add;
        }
    }

    private static int digitSum(int n){
        int sum = 0;
        while(n > 0){
            int last = n % 10;
            sum += last;
            n = n / 10;
        }
        return sum;
    }

    //////////////// Find Ugly Number \\\\\\\\\\\\\\\\\\\\\
    
    public static boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        while(n % 2 == 0){
            n /= 2;
        }
        while(n % 3 == 0){
            n /= 3;
        }
        while(n % 5 == 0){
            n /= 5;
        }
        return n == 1;
    }

    ///////////////////// Find Nth ugly Number \\\\\\\\\\\\\\\\\\\\\\

    public static  int nthUglyNumber(int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        for(int i = 1; i < n; i++){
            int i1 = dp[a1] * 2;
            int i2 = dp[a2] * 3;
            int i3 = dp[a3] * 5;

            dp[i] = Math.min(i1, Math.min(i2, i3));

            if(dp[i] == i1){
                a1++;
            }
            if(dp[i] == i2){
                a2++;
            }
            if(dp[i] == i3){
                a3++;
            }

        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int digit = 56;
        System.out.println(addDigits(digit));

        int n = 14;
        System.out.println(isUgly(n));

        int n1 = 10;
        System.out.println(nthUglyNumber(n1));


    }
}
