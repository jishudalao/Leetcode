package leetcodemianshi54;
/*if(index++==k){
    res=root.val;
    return;
}*/
public class KthLargest {
	//平衡树，暗示就是中序遍历
	int index=1,res=0;
	public int kthLargest(TreeNode root, int k) {
		backtrack(root,k);
		return res;
    }

	private void backtrack(TreeNode root, int k) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		//注意，要先遍历右子树
		backtrack(root.right, k);
		if(index++==k) {
			res=root.val;
			return;
		}
		
		backtrack(root.left, k);
	}
	
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }