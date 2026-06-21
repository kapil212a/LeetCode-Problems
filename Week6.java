import java.util.Arrays;

public class Week6 {

    ///////////////// Print Arrays \\\\\\\\\\\\\\\\\\\\

    public static void printArr(int arr[]){
        System.out.print("[");
        for(int num : arr){
            System.out.print(num + " ");
        }System.out.println("]");
    }


    ////////////////// Sort The color \\\\\\\\\\\\\\\\\\ 
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    private static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    ///////////////////// Maximum Ice Cream Bars \\\\\\\\\\\\\\\\\\\
    
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int bars = 0;

        for(int cost : costs){
            if(coins < cost){
                break;
            }
            coins -= cost;
            bars++;
        }
        return bars;
    }



    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        printArr(nums);

        int costs[] = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
        
    }

}
