package leetcode95;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
	public static void main(String[] args) {
		System.out.println(generateTrees(5));
	}
	public static List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();
        return helper(1, n);

    }

    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int val = start; val <= end; val++) {
            List<TreeNode> left = helper(start, val - 1);
            List<TreeNode> right = helper(val + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(val);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
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