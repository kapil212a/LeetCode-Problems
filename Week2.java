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

    public static void main(String[] args) {
        int num = 12357;
        System.out.println(intToRoman(num));
    }
}

