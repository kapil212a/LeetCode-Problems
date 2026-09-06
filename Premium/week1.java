package Premium;

public class week1 {
    public static  class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    ///////////////////////// Binary Tree Upside Down \\\\\\\\\\\\\\\\\\\\
                        //     1
                        //    / \
                        //   2   3
                        //  / \
                        // 4   5

                            //  4
                            // / \
                            // 5   2
                            //     / \
                            //     3   1
                        
    public static TreeNode upSideDown(TreeNode root){
        if(root == null && root.left == null){
            return root;
        }
        TreeNode newNode = upSideDown(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
    }
}
