public class Array9 {
    ////////////// Minimum Moves to Equal Array Elements \\\\\\\\\
    
    public static int minMoves(int nums[]){
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            min = Math.min(nums[i], min);

        }
        int count = 0;
        for(int i = 0; i <nums.length; i++){
            count += nums[i] - min;
        }
        return count;
    }


    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(minMoves(nums));
    }
}
