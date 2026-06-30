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


    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        List<List<Integer>> x = levelOrderBottom(node);
        System.out.println(x);

        int nums[] = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));

    }

}
