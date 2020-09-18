package leetcode1566;

public class Leetcode1566 {
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return backtrack(root.left,root.right);
	}
	
	boolean backtrack(TreeNode left, TreeNode right) {
		if(left==null && right==null) {
			return true;
		}
		if(left==null || right==null) {
			return false;
		}
		if(left.val!=right.val) {
			return false;
		}
		return backtrack(left.left,right.right) && backtrack(left.right,right.left);
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}