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

    //////////////////Sum Root to Leaf Numbers \\\\\\\\\\\\\\\\\\\
        
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

    static int max = Integer.MIN_VALUE;
    public static int pairSum(TreeNode root){
        sum(root);
        return max;
    }
    
    public static int[] sum( TreeNode root){
        if(root == null){
            return new int[]{0 , 0};
        }
        int[] left = sum(root.left);
        int[] right = sum(root.right);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        max = Math.max(max , sum/count);

        return new int[]{sum, count};
    }
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);           
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumNumbers(root));

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);           
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(pairSum(root1));
    }
}
