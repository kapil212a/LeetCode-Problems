import java.util.ArrayList;
import java.util.List;

public class week11 {
    ////////////  The k-th Lexicographical String of All Happy Strings of Length n \\\\\\\\\\\\\\
    
    static List<String> list = new ArrayList<>();
    public static String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        backTrack(n , sb);
        if(k > list.size()){
            return "";
        }

        return list.get(k - 1);


    }
    private static void backTrack(int n, StringBuilder sb){
        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }

        char chStr[] = {'a', 'b', 'c'};

        for(char ch : chStr){
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != ch){
                sb.append(ch);

                backTrack(n, sb);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 1 , k = 3;
        System.out.println(getHappyString(n, k));
    }
}
