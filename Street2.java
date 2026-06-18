import java.util.Arrays;

public class Street2 {
    //////////// Angle Between Hands Of Clock \\\\\\\\\\\\\\\\
    
    public static double angleClock(int hour, int minutes) {
        double hourAngle = 30 * hour + 0.5 * minutes;
        double minAngle = 6 * minutes;

        double angle = Math.abs(hourAngle - minAngle);

        return Math.min(angle , 360 - angle);
    }

    //////////////// Minimum Difference Between Highest and Lowest of K Scores \\\\\\\\\\\\\\\\
    
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= nums.length - k ; i++){
            min = Math.min(min,nums[i + k - 1] - nums[i]);
        }
        return min;
    }



    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;
        System.out.println(angleClock(hour, minutes));

        int nums[] = {9,4,1,7};
        int k = 2;
        System.out.println(minimumDifference(nums, k));
    }

}
