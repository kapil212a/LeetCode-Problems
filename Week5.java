import java.util.ArrayList;
import java.util.List;

public class Week5 {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();

        int fact = 1;
        for(int i = 1; i < n; i++){
            fact *= i;
        }
        for(int i = 1; i <= n; i++){
            num.add(i);
        }
        k = k - 1;

        StringBuilder str = new StringBuilder();
        while(num.size() > 0){
            int idx = k / fact;

            str.append(num.get(idx));

            num.remove(idx);

            if(num.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / num.size();
        }
        return str.toString();
    }
    public static void main(String[] args) {
        
    }
}
