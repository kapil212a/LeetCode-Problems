import java.util.HashSet;

public class week8 {
    /////////////// Longest Consecutive Sequence \\\\\\\\\\\\\\\
    
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();

        for(int num : nums){
            ans.add(num);
        }
        int sum = 0;

        for(int num : ans){
            if(!ans.contains(num - 1)){
                int curr = num;
                int len = 1;

                while(ans.contains(curr + 1)){
                    curr++;
                    len++;
                }
                sum = Math.max(sum , len);
            }
        }
        return sum;
    }

    /////////////////////////
    public static void main(String[] args) {
        int num[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));
    }
}
