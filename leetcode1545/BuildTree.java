package leetcode1545;

public class BuildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return backtack(preorder, 0,preorder.length-1, inorder,0,inorder.length-1);
    }

	private TreeNode backtack(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
		// TODO Auto-generated method stub
		if(prestart>preend||instart>inend) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[prestart]);
		for (int i = instart; i <= inend; i++) {
			if(preorder[prestart]==inorder[i]) {
				root.left = backtack(preorder, prestart+1, prestart+(i-instart), inorder, instart, i-1);
				root.right = backtack(preorder, prestart+(i-instart)+1, preend, inorder, i+1, inend);
			}
		}
		return root;
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
