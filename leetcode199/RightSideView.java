package leetcode199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
	//广度优先搜索
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int len = queue.size();
			for(int i=0;i<len;i++) {
				TreeNode cur = queue.poll();
				if(i==0) {
					res.add(cur.val);
				}
				if(cur.right!=null) {
					queue.offer(cur.right);
				}
				if(cur.left!=null) {
					queue.offer(cur.left);
				}
			}
		}
		return res;
    }
	
	/*
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //bfs
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if(i == 0) {
                    ans.add(cur.val);
                }

                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }

        return ans;
    }*/
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }