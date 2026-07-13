import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class week8 {
    public static void printArr(int arr[]){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + " ");
        }System.out.println("]");
    }
    /////////////// Longest Consecutive Sequence \\\\\\\\\\\\\\\
    
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();

        for(int num : nums){
            ans.add(num);
        }
        int sum = 0;

        for(int num : ans){
            if(!ans.contains(num - 1)){
                int curr = num;
                int len = 1;

                while(ans.contains(curr + 1)){
                    curr++;
                    len++;
                }
                sum = Math.max(sum , len);
            }
        }
        return sum;
    }

    /////////////////////Longest Balance Substring I \\\\\\\\\\\\\\\\\\\\\
    
    public static int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int frq[] = new int[26];

            int dist = 0;
            int max = 0;

            for(int j = i; j < n; j++){
                int idx = s.charAt(j) - 'a';

                if(frq[idx] == 0){
                    dist++;
                }
                frq[idx]++;
                max = Math.max(max , frq[idx]);

                int len = j - i + 1;

                if(len == max * dist){
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }

    ////////////////// Rank Transform Of an Array \\\\\\\\\\\\\\\

    public static int[] arrayRankTransform(int[] arr) {
        int [] temp = new int[arr.length];

        int newTemp[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            newTemp[i] = arr[i];
        }

        Arrays.sort(newTemp);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : newTemp){
            if(!map.containsKey(num)){
                map.put(num , rank);
                rank++;
            }
        }

        for(int i = 0; i < arr.length; i++){
            temp[i] = map.get(arr[i]);
        }
        return temp;
    }

    //////////////////////// Evaluate Reverse Polish Notation \\\\\\\\\\\\\\\\\\\

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String str : tokens){
            if(str.equals("+")){
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
            }
            else if(str.equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            }
            else if(str.equals("*")){
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
            }
            else if(str.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a / b);
            }
            else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }


    public static void main(String[] args) {
        int num[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));

        String s = "abbac";
        System.out.println(longestBalanced(s));

        int arr[] = {40, 10, 20, 30};
        printArr(arrayRankTransform(arr));

        String []tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
