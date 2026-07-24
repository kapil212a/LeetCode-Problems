
import java.util.*;

public class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();

        pushLeft(node.right);

        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator obj = new BSTIterator(root);
        while (obj.hasNext()) {
            System.out.print(obj.next() + " ");
        }
    }
}
