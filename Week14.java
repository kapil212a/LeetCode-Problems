public class Week14 {
    ///////////////////  Sun Game \\\\\\\\\\\\\\\\\\\\\\
    
    public static boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;

        int sum1 = 0;
        int sum2 = 0;
        int qSum1 = 0;
        int qSum2 = 0;

        for(int i = 0; i < mid; i++){
            if(num.charAt(i) == '?'){
                qSum1++;
            }
            else{
                sum1 += num.charAt(i) - '0';
            }
        }

        for(int i = mid; i < n; i++){
            if(num.charAt(i) == '?'){
                qSum2++;
            }
            else{
                sum2 += num.charAt(i) - '0';
            }
        }

        int diff = sum1 - sum2;
        int qDiff = qSum2 - qSum1;

        return 2 * diff != qDiff * 9;
    }

    ///////////Remove Min And Max From Array \\\\\\\\\\\\\
    /// 
    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] < nums[min]){
                min = i;
            }

            if(nums[i] > nums[max]){
                max = i;
            }
        }
        if(min > max){
            int temp = min;
            min = max;
            max = temp;
        }

        int front = max + 1;
        int back = n - min;

        int both = (min + 1) + (n - max);

        return Math.min(front, Math.min(back, both));
    }


    public static void main(String[] args) {
        String num = "5023"; ////////// ?3295???;
        System.err.println(sumGame(num));

        int arr1[] = {2,5,6,0,0,1,2};
        minimumDeletions(arr1);

    }

}
