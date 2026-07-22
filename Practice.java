import java.util.Scanner;

public class Practice {
    public static int value(char ch){
        if(ch == 'I') return 1;
        if(ch == 'V') return 5;
        if(ch == 'X') return 10;
        if(ch == 'L') return 50;
        if(ch == 'C') return 100;
        if(ch == 'D') return 500;
        return 1000;
    }

    public static int roman(String s){
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            
            int digit = value(s.charAt(i));
            
            if(i + 1 < s.length() && digit < value(s.charAt(i + 1))){
                sum -= digit;
            }
            else{
                sum += digit;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        //String s = "MCCXCIX";
        System.out.println(roman(num));
    }
}
