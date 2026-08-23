import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
    
    ////////////////////////// Right side View Of the Tree \\\\\\\\\\\\\\\\\\\\\\\\\
    
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        

        while(!qu.isEmpty()){
            int size = qu.size();

            for(int i = 0; i < size; i++){
                TreeNode node = qu.poll();

                if(i == size - 1){
                    ans.add(node.val);
                }
                if(node.left != null){
                    qu.offer(node.left);
                }
                if(node.right != null){
                    qu.offer(node.right);
                }

            }
        }
        return ans;
    }

    ///////////////////// Path Of Binary Tree \\\\\\\\\\\\\\\\\
    
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        preorder(root ,"", ans);
        return ans;
    }

    private static void preorder(TreeNode root, String s, List<String>ans){
        if(root == null){
            return;
        }
        s += root.val;
        
        if(root.left == null && root.right == null){
            ans.add(s);
            return;
        }
        s += "->";
        preorder(root.left, s, ans);
        preorder(root.right, s, ans);
    }

    ///////////////////Kth samllest element in BST \\\\\\\\\\\\\\\\\\

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while(true){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }
    }

    //////////////////// Lowest Common Ancestor of a Binary Search Tree \\\\\\\\\\\\\

     public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

         if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
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

        List<Integer > list = rightSideView(root1);
        System.out.println(list);

       System.out.println(binaryTreePaths(root1));

       kthSmallest(root1, 3);
       //System.out.println(lowestCommonAncestor(root1, 2, 8));
    }
}
