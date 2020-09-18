package leetcode1570;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode1570 {
	//这题想都不用想就是队列
	public int[] levelOrder(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root==null) {
			return new int[0];
		}
		queue.offer(root);
		ans.add(root.val);
		while(!queue.isEmpty()) {
			TreeNode tree = queue.poll();
			if(tree.left!=null) {
				queue.offer(tree.left);
				ans.add(tree.left.val);
			}
			if(tree.right!=null) {
				queue.offer(tree.right);
				ans.add(tree.right.val);
			}
		}
		int res[] = new int[ans.size()];
		for(int i=0;i<ans.size();i++) {
			res[i] = ans.get(i);
		}
       return res;
    }
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }