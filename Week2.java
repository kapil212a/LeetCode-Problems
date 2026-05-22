public class Week2 {
    ////// Integer To Roman//////
    
    public static String intToRoman(int num) {
        int [] value = {
                        1000,900,500,
                        400,100,90,50,
                        40,10,9,5,4,1
                    };

        String [] symbol = {
                            "M", "CM", "D", "CD",
                            "C", "XC", "L", "XL", 
                            "X", "IX", "V", "IV", "I"
                        }; 

        StringBuilder res = new StringBuilder();

        for(int i = 0; i<value.length; i++){
            while(num >= value[i]){
                res.append(symbol[i]);

                num = num - value[i];
            }
        }
        return res.toString();
    }

    //// Roman To Integer /////
    
    public static int value(char ch){
        if(ch == 'I') return 1;
        if(ch == 'V') return 5;
        if(ch == 'X') return 10;
        if(ch == 'L') return 50;
        if(ch == 'C') return 100;
        if(ch == 'D') return 500;
        return 1000;
    }

    
    public static int romanToInt(String s) {
        int total = 0;

        for(int i = 0; i< s.length(); i++){
            int curr = value(s.charAt(i));

            if(i+1 < s.length() && curr < value(s.charAt(i+1))){
                total = total - curr;
            }
            else{
                total = total + curr;
            }
        }
        return total;
    }

    //// Longest Common Prefix ////////
    
    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for(int i = 0; i<first.length(); i++){
            char ch = first.charAt(i);

            for(int j = 1; j<strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return first.substring(0,i);
                }
            }
        }
        return first;
    }


    public static void main(String[] args) {
        int num = 12357;
        System.out.println(intToRoman(num));

        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

        String [] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}

