package BinaryTrees;

public class Tree3 {
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        return Math.max(helper(root.left),helper(root.right))+1;
    }
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
}
