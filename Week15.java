import java.util.*;
public class Week15 {
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

    public static void main(String[] args) {
        String arr[] = {"act", "god", "cat", "dog", "tac"};
        ArrayList<ArrayList<String>> x = anagram(arr);
        System.out.println(x);
    }
}
