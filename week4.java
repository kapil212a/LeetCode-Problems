public class week4 {
    /////////// EARLIER FINISH TIME OF WATER AND LAND \\\\\\\\\
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i< landStartTime.length; i++){
            int landFinish = landStartTime[i] + landDuration[i];

            for(int j = 0; j < waterStartTime.length; j++){
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finish = waterStart + waterDuration[j];

                ans = Math.min(ans, finish);
            }
        }

        for(int i = 0; i < waterStartTime.length; i++){
            int waterFinish = waterStartTime[i] + waterDuration[i];

            for(int j = 0; j < landStartTime.length; j++){
                int landStart = Math.max(waterFinish, landStartTime[j]);
                int finish = landStart + landDuration[j];

                ans = Math.min(ans, finish);
            }
        }
        return ans;
    }

    //////// FIRST MISSING POSITIVE NUMBER \\\\\\\\\

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        int i = 0;

        while(i < n){
            int correct = nums[i] - 1;

            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }
        for(i = 0; i < n; i++){
            if(nums[i] != i +1){
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
       int landStartTime[] = {2,8}, landDuration[] = {4,1};
       int waterStartTime [] = {6}, waterDuration[] = {3};
       System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));

       int nums[] = {7,8,9,11,12};
       System.out.println(firstMissingPositive(nums));
    }
}
