import java.util.*;

public class Tree2 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    //////////////// Binary Tree Level Order Traversal II (Bottom -------->  Root)\\\\\\\\\\\\\\\
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode curr = qu.poll();
                level.add(curr.val);

                if(curr.left != null){
                    qu.offer(curr.left);
                }
                if(curr.right != null){
                    qu.offer(curr.right);
                }
            }
            ans.add(0, level);
        }
        return ans;
    }

    //////////// Convert Sorted Array to Binary Search Tree \\\\\\\\\\\\
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums , 0 , nums.length - 1);
    }

    private static TreeNode buildTree(int nums[] , int left , int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left,mid - 1);
        root.right = buildTree(nums,mid + 1, right);

        return root;
    }

    /////////////////////// determine if it is height-balanced \\\\\\\\\\\\\\\\\

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left  = height(root.left);
        if(left == -1){
            return -1;
        }

        int right = height(root.right);
        if(right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left , right) + 1;
    }



    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        List<List<Integer>> x = levelOrderBottom(node);
        System.out.println(x);

        int nums[] = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
        preorder(sortedArrayToBST(nums));

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);            ///3,9,20,null,null,15,7
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }

}
