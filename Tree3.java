public class Tree3 {
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

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public static int dfs(TreeNode root , int curr){
        if(root == null){
            return 0;
        }

        curr = curr * 10 + root.val;

        if(root.left == null && root.right == null){
            return curr;
        }
        return dfs(root.left , curr) + dfs(root.right, curr);
    }
}
