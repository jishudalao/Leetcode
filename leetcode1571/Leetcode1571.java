package leetcode1571;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode1571 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root==null) {
			return ans;
		}
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int len = queue.size();
			for(int i=0;i<len;i++) {
					TreeNode tree = queue.poll();
						list.add(tree.val);
					if(tree.left!=null) {
						queue.offer(tree.left);
					}
					if(tree.right!=null) {
						queue.offer(tree.right);
				}
			}
				ans.add(list);
		}
		return ans;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}