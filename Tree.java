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
    }
}
