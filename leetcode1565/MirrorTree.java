package leetcode1565;

public class MirrorTree {
	public TreeNode mirrorTree(TreeNode root) {
        return backtrack(root);
    }
	private TreeNode backtrack(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return root;
		}
		TreeNode left = root.left;
		root.left = backtrack(root.right);
		root.right = backtrack(left);
		return root;
	}
	public static void main(String[] args) {
	
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }