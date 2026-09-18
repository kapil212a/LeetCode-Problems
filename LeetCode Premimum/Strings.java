
import java.util.*;

public class Strings {
    ////////////longest Substring with at most two  distinct character \\\\\\\\\\\\
    public static int distinct(String s){
        int max = 0;
        int left = 0;
        HashMap <Character , Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size() > 2){
                char newCh = s.charAt(left);
                map.put(newCh, map.get(newCh) - 1);

                if(map.get(newCh) == 0){
                    map.remove(newCh);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
           
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(distinct(s));
    }
}
