public class week10 {
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

    public static void main(String[] args) {
        int n = 3;
        System.out.println(concatenatedBinary(n));
    }
}
