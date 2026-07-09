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

    //////////// Minimum depth of binary tree \\\\\\\\\\\\\\\

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){

            return minDepth(root.left) + 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left , right) + 1;
    }

    /////////////// Path Sum \\\\\\\\\\\\\\\\\\\

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        targetSum = targetSum - root.val;

        return hasPathSum(root.left , targetSum) || hasPathSum(root.right , targetSum);
    }

    //////////////// Path Sum II \\\\\\\\\\\\\\\\

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, ans);
        return ans;
    }

    public static void dfs(TreeNode root, int targetSum, List<Integer> path,  List<List<Integer>> ans){
        if(root == null){
            return;
        }

        path.add(root.val);

        if(root.left == null && root.right == null && targetSum == root.val){
            ans.add(new ArrayList<>(path));
        }
        targetSum = targetSum - root.val;

        dfs(root.left, targetSum, path, ans);
        dfs(root.right, targetSum, path, ans);

        path.remove(path.size() - 1);
    }

    /////////////////// Binary Tree to LinkedList\\\\\\\\\\\\\

    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if(root.left != null){

            TreeNode temp = root.left;

            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }

    }

    ////////////// PreOrder Traversal \\\\\\\\\\\\\
    
    static List<Integer> node = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {
        
        preorder1(root);
        return node;
    }

    private static void preorder1(TreeNode root){
        if(root == null){
            return ;
        }

        node.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /////////////// Binary Tree Postorder Traversal\\\\\\\\\\\\\\\

    static List<Integer> ans = new ArrayList<>();
    public static List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return ans;
    }

    private static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.val);
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
        root.right = new TreeNode(20);           
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));

        System.out.println(minDepth(root));

        System.out.println(hasPathSum(root, 12));
        System.out.println(pathSum(root, 12));

        flatten(root);
        preorder(root);

        List<Integer> y = preorderTraversal(root);
        System.out.println(y);

        List<Integer> z = postorderTraversal(root);
        System.out.println(z);

    }

}
