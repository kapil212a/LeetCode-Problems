import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    ///////////////////// Combination \\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(1, n, k, new ArrayList<>(), ans);
        return ans;
    }
    private static void helper(int start, int n, int k, List<Integer>list, List<List<Integer>>ans){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            helper(i + 1, n, k, list, ans);
            list.remove(list.size() - 1);
        }
    }

    ///////////////////////////// Subset Of Given Nums \\\\\\\\\\\\\\\\\\\\\\

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(0 , nums, new ArrayList<>() , ans);
        return ans;
    }

    private static void helper(int start, int []nums, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);

            helper(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }


    ///////////////////// REmove Dublicates from sorted array \\\\\\\\\\\\\\\\\

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int j = 0;
        for(int num : nums){
            if(j < 2 || num != nums[j - 2]){
                nums[j] = num;
                j++;
            }
        }
        return j;
    }

    //////////////////// Search In sorted Array \\\\\\\\\\\\\\\\\\\\\\\\\

    public static boolean search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid]){
                left++;
            }
            else if(nums[left] < nums[mid]){
                if(target >= nums[left] && nums[mid] > target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    ////////////////// Merge Sorted Arrays \\\\\\\\\\\\\\\\\\\\\\
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n -1, k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }

    }

    ///////////////// Grey Code \\\\\\\\\\\\\\\\\\\\\

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for(int i = 0; i < n; i++){
            int size = result.size();

            int value = 1 << i;
            for(int j = size - 1; j >= 0; j--){
                result.add(result.get(j) + value);
            }
        }
        return result;
    }

    ////////////////////// Subset II \\\\\\\\\\\\\\\\\\\\

    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());

        return ans;
    }

    private static void backtrack(int nums[] , int idx, List<Integer> curr){
        ans.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i -1]){
                continue;
            }

            curr.add(nums[i]);
            backtrack(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    //////////// Find Smallest Letter Greater then Target \\\\\\\\\\\\\\\\\\\\

    public static char nextGreatestLetter(char[] letters, char target) {
        for(int i = 0;  i < letters.length; i++){
            if(letters[i] - target > 0){
                return letters[i];
            }
        }
        return letters[0];
    }


    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        printArr(nums);

        int costs[] = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));

        int n = 4, k = 2;
        List<List<Integer>> list = combine(n, k);
        System.out.println(list);
            
        int nums1[] = {1,2,3};
        List<List<Integer>> list1 = subsets(nums1);
        System.out.println(list1);

        int arr[] = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));

        int arr1[] = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(arr1, target));

        int nums2[] = {1,2,3,0,0,0};
        int nums3[] = {2,5,6};
        int m = 3, n1 = 3;
        merge(nums2, m, nums3, n1);
        printArr(nums2);

        int n2 = 4;
        System.out.println(grayCode(n2));

        int[] nums5 = {1,2,2};
        List<List<Integer>> x = subsetsWithDup(nums5);
        System.out.println(x);

        char letters[] = {'c','f','j'};
        char target1 = 'a';
        System.out.println(nextGreatestLetter(letters, target1));

    }

}
