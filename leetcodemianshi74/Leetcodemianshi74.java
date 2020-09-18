package leetcodemianshi74;

public class Leetcodemianshi74 {
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	 return backtrack(root,p,q);
    }
private TreeNode backtrack(TreeNode root, TreeNode p, TreeNode q) {
	// TODO Auto-generated method stub
	if(root==null||root==p||root==q) {
		return root;
	}
	TreeNode left = backtrack(root.left, p, q);
	TreeNode right = backtrack(root.right, p, q);
	if(left==null) {
		return right;
	}
	if(right==null) {
		return left;
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