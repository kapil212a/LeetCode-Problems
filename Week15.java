import java.util.*;
public class Week15 {
    //////////////////////// Group the anagram Strings In a list \\\\\\\\\\\\\\\\\\\\\\\\
    public static ArrayList<ArrayList<String>> anagram(String arr[]){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String , Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            String s = arr[i];

            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            s = new String(ch);

            if(!map.containsKey(s)){
                map.put(s, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(s)).add(arr[i]);
  
        }
        return res;
    }

    ////////////// Rectangle overlap \\\\\\\\\\\\\\

    public static  boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int left = Math.max(rec1[0], rec2[0]);
        int right = Math.min(rec1[2], rec2[2]);

        int bottom = Math.max(rec1[1], rec2[1]);
        int top = Math.min(rec1[3], rec2[3]);

        return left < right && bottom < top;
    }


    public static void main(String[] args) {
        String arr[] = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> x = anagram(arr);
        System.out.println(x);

        int rec1[] = {0,0,2,2};
        int rec2[] = {0,0,2,2};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }
}
