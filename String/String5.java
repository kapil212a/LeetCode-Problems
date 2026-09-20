package String;

public class String5 {
    //////////////////// Reverse The Degree Of String \\\\\\\\\\\\\
    public static int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int val = 'z' - ch + 1;
            sum += val * (i + 1);
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "zaza";
        System.out.println(reverseDegree(s));
    }
}
