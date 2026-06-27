import java.util.*;
public class Tree {
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

    ////////////// Print Tree \\\\\\\\\\\\\\\\\\\
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }
        
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    ///////////////// Build BST \\\\\\\\\\\\\\\\\\\\\\\\\\

    public static TreeNode buildBST(TreeNode root , int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(root.val > value){
            root.left = buildBST(root.left , value);
        }
        else{
            root.right = buildBST(root.right , value);
        }
        return root;
    }

    /////////////////// Inorder traversal on tree /\\\\\\\\\\\\\
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        inorder(root , ans);
        return ans;
    }
    private static void inorder(TreeNode node , List<Integer> ans){
        if(node == null){
            return;
        }
        inorder(node.left ,ans);
        ans.add(node.val);
        inorder(node.right, ans);
    } 

    ///////////////////// Build All Unique Binary Tree Possible \\\\\\\\\\\\\\\\\\

    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return buildBST(1 , n);
    }
    private static List<TreeNode> buildBST(int start , int end){
        List<TreeNode> list  = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = buildBST(start , i - 1);
            List<TreeNode> right = buildBST(i + 1 , end);

            for(TreeNode l : left){
               for(TreeNode r : right){
                    TreeNode root  = new TreeNode(i);

                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    //////////////////// Count The Number Of Unique Binary Tree \\\\\\\\\\\\\\\

    public static int numTrees(int n) {
        int dp[] = new int [n  +1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                int left = j - 1;
                int right = i - j;

                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }

    ////////////////////// Valid Binary Search Tree \\\\\\\\\\\\\\\\\\\\

    public static boolean isValidBST(TreeNode root) {
        //long min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean valid(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }
        if(node.val <= min || node.val >= max){
            return false;
        }
        return valid(node.left, min, node.val) && valid(node.right , node.val, max);
    }

    /////////////// Recover BInary Search Tree \\\\\\\\\\\\\\\\\\\\\

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;

    public static void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
    private static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second  = root;
        }
        prev = root;
        inorder(root.right);
    }

    //////////////////// Check The Two Tree Are Same \\\\\\\\\\\\\\\\\\

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    ///////////////////////// Symmitric tree \\\\\\\\\\\\\\\\\\\\\\\\\\\

    public static boolean isSymmetric(TreeNode root) {
        return miror(root.left , root.right);
    }

    private static boolean miror(TreeNode left , TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return miror(left.left , right.right) && miror(left.right, right.left);
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        //node.left = new TreeNode(null);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        List<Integer> x = inorderTraversal(node);
        System.out.println(x);

        int n = 3;
        List<TreeNode> y = generateTrees(n);
        //System.out.println(generateTrees(n));
        for(TreeNode a : y){
            System.out.print("[");
            System.out.print(a.val + " ");
           if(a.left == null){
            System.out.print("null" + " ");
           }
           else{
            System.out.print(a.left.val + " ");
           }
           if(a.right ==  null){
            System.out.print("null" + " ");
           }
           else{
            System.out.print(a.right.val + " ");
           }
           System.out.println("]");

           int n1 = 3;
           System.out.println(numTrees(n1));


        }
        TreeNode node1 = new TreeNode(2);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(3);
        System.out.println(isValidBST(node1));

        TreeNode node3 = new TreeNode(1);
        node3.left = new TreeNode(3);
        node3.left.right = new TreeNode(2);
        recoverTree(node3);
        printTree(node3);

        System.out.println(isSameTree(node1, node3));

        int value[] = {1,2,2,3,4,4,3};
        TreeNode root = null;
        for(int i = 0; i < value.length; i++){
            root = buildBST(root, value[i]);
        }
        printTree(root);
        System.out.println(isSymmetric(root));
    }
}
