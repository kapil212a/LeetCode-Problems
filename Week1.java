public class Week1 {
    //// Minimum Distnace from target////
    
    public static int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target){
                int distance = Math.abs(i - start);
                minDistance = Math.min(minDistance , distance);
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5};
        int target = 5;
        int start = 3;
        System.out.println(getMinDistance(nums , target , start));
    }
}
