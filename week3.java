public class week3 {
    /////// PRINT ARRSY \\\\\\\\

    public static void printArr(int [] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
    ///// FIND THE INDEX OF THE FIRST OCCURENCE IN A STRING \\\\
    
     public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0; i<= n-m; i++){
            int j = 0;

            while(j < m && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j == m){
                return i;
            }
        }
        return -1;
    }

    ///// DIVIDE TWO INTEGER WITHOUT USING /, * , OPERATOR \\\\\\\

    public static int divide(int dividend, int divisor) {
        boolean neg = (dividend < 0) ^ (divisor < 0);

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long)divisor);

        int ans = 0;
        while(dvd >= dvs){
            long temp = dvs;
            int mul = 1;

            while(dvd >= (temp << 1)){
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            ans += mul;
        }
        if(neg){
            return -ans;
        }
        else{
            return ans;
        }
    }

    ///// MINIMUM ELEMENT AFTER REPLACEMENT WITH DIGIT SUM IN ARRAY \\\\\\

    public static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            int sum = 0;

            while(num > 0){
                sum +=  num % 10;
                num = num / 10;
            }
            min = Math.min(min , sum);
        }
        return min;
    }


    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));

        int dividend = 100;
        int divisor = 15;
        System.out.println(divide(dividend, divisor));

        int arr[] = {10,12,15,25};
        System.out.println(minElement(arr));
        printArr(arr);
    }
}
