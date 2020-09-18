package leetcode1602;

public class Leetcode1602 {
	//������������������������
	//���������1��n�ĺ�
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