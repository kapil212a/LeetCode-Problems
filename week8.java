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

    /////////////////////////Longest Balance Substring I \\\\\\\\\\\\\\\\\\\\\
    
    public static int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int frq[] = new int[26];

            int dist = 0;
            int max = 0;

            for(int j = i; j < n; j++){
                int idx = s.charAt(j) - 'a';

                if(frq[idx] == 0){
                    dist++;
                }
                frq[idx]++;
                max = Math.max(max , frq[idx]);

                int len = j - i + 1;

                if(len == max * dist){
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int num[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));

        String s = "abbac";
        System.out.println(longestBalanced(s));
    }
}
