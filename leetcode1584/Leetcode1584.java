package leetcode1584;

import java.util.ArrayList;
import java.util.List;
public class Leetcode1584 {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> cur = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root==null) {
			return res;
		}
		backtrack(root,sum);
		return res;
    }
	private void backtrack(TreeNode root, int sum) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		cur.add(root.val);
		sum -= root.val;
		if(sum==0&&root.left==null&&root.right==null) {
			res.add(new ArrayList<>(cur));
		}
		backtrack(root.left, sum);
		backtrack(root.right, sum);
		cur.remove(cur.size()-1);
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }