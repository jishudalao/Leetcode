package leetcodemianshi37;

import java.util.ArrayDeque;
import java.util.Queue;
public class Leetcodemianshi37 {
	public String serialize(TreeNode root) {
		  StringBuilder sb = new StringBuilder("");
	    return xuliehua(root, sb).toString();
	  }
	public StringBuilder xuliehua(TreeNode root, StringBuilder sb) {
	    if (root == null) {
	    	sb.append("null,");
	    } else {
	    	sb.append(root.val);
	    	sb.append(",");
	    	sb = xuliehua(root.left, sb);
	    	sb = xuliehua(root.right, sb);
	    }
	    return sb;
	  }

	  // Encodes a tree to a single string.
	  
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        Queue<String> queue = new ArrayDeque<>();
        for(String s : res) {
        	queue.add(s);
        }
        return fanxulie(queue);
    }
    public TreeNode fanxulie(Queue<String> queue) {
    	if(queue.peek().equals("null")) {
    		queue.poll();
    		return null;
    	}
    	int node = Integer.valueOf(queue.poll());
    	TreeNode tree = new TreeNode(node);
    	tree.left = fanxulie(queue);
    	tree.right = fanxulie(queue);
    	return tree;
    }
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }