package BinaryTrees;

public class BST1
 {

    public void helper(TreeNode root, List<Integer> li){
        if(root==null){
            return;
        }
        helper(root.left,li);
        li.add(root.val);
        helper(root.right,li);

    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li=new ArrayList<>();
        helper(root,li);
        return li.get(k-1);
    }
}