package leetcodemianshi54;
/*if(index++==k){
    res=root.val;
    return;
}*/
public class KthLargest {
	//ƽ��������ʾ�����������
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
		//ע�⣬Ҫ�ȱ���������
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