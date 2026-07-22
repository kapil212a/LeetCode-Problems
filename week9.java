import java.util.Arrays;

public class week9 {
    /////////////////////// Maximum Gap Between Numbers \\\\\\\\\\\\\\\\\\  
    
    public static int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int diff = 0;
        int max = 0;
        if(nums.length == 1){
            return 0;
        }
        for(int i = 0; i < nums.length - 1; i++){
            diff = nums[i+1] - nums[i];
            max = Math.max(diff , max);
        }
        return max;
    }

    ///////////////// Compaire Version Number \\\\\\\\\\\\\\\\\ 

    public static int compareVersion(String version1, String version2) {
        String [] a = version1.split("\\.");
        String [] b = version2.split("\\.");

        int n = Math.max(a.length , b.length);

        for(int i = 0; i < n; i++){
            int x = 0;
            int y = 0;

            if(i < a.length){
                x = Integer.parseInt(a[i]);
            }

            if(i < b.length){
                y = Integer.parseInt(b[i]);
            }

            if(x < y){
                return -1;
            }
            if(x > y){
                return 1;
            }
        }
        return 0;
    }
    ///////////////////// Two Sum II - Input Array Is Sorted \\\\\\\\\\\

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1 , right + 1};
            }
            if(sum > target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        int num[] = {3,6,9,1};
        System.out.println(maximumGap(num));

        String version1 = "1.2";
        String version2 = "1.10";
        System.out.println(compareVersion(version1, version2));

        int numbers[] = {2,7,11,15};
        int target = 9;
        int nums[] = twoSum(numbers, target);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}
