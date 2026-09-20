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

    ////////////////// Furthest Point From Origin /\\\\\\\\\'\\\\\
    public static  int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int empty = 0;

        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);

            if(ch == 'L'){
                l++;
            }
            else if(ch == 'R'){
                r++;
            }
            else if(ch == '_'){
                empty++;
            }
        }
        return Math.abs(l - r) + empty;
    }



    public static void main(String[] args) {
        String s = "zaza";
        System.out.println(reverseDegree(s));

        String moves = "L_RL__R";
        System.out.println(furthestDistanceFromOrigin(moves));
    }
}
