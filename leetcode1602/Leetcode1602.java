package leetcode1602;

public class Leetcode1602 {
	//这题可以用树的深度优先搜索
	//把这题想成1到n的和
	public int maxDepth(TreeNode root) {
		return backtrack(root);
    }

	private int backtrack(TreeNode root) {
		if(root==null) {
			return 0;
		}
		return Math.max(backtrack(root.left), backtrack(root.right))+1;
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}