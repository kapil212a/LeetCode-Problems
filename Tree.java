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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        //node.left = new TreeNode(null);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        List<Integer> x = inorderTraversal(node);
        System.out.println(x);
    }
}
