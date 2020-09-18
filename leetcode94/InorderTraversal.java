package leetcode94;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
	List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		zhongxu(root);
		return res;
		
    }
	public void zhongxu(TreeNode root) {
		if (root != null) {
        if (root.left != null) {
        	zhongxu(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
        	zhongxu(root.right);
        }
    }	
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }