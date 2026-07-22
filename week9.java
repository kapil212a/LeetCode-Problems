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

    public static void main(String[] args) {
        int num[] = {3,6,9,1};
        System.out.println(maximumGap(num));
    }
}
