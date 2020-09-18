package leetcodemianshi26;

public class IsSubStructure {
	//深度优先搜索啊
	//分两步，要比较B树是否是否是a的子结构,第一步是对准
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(A==null || B==null){
            return false;
        }
		//这一步不能分开写，因为分开写不能判断到只有头结点匹配余下不匹配的情况
		return subCheck(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean subCheck (TreeNode A, TreeNode B){
        //如果B为null，则表示匹配完成，直接返回true
        if(B==null){
            return true;
        }
        //如果A为null（此时B不为null） 或者 A的值不等于B的值，那么，匹配失败，直接返回false
        if(A==null || A.val!=B.val){
            return false;
        }
        //继续匹配A的左子树和B的左子树 && A的右子树和B的右子树(此处为and的关系，一旦出现false，则意味着匹配失败)
        return subCheck(A.left,B.left)&&subCheck(A.right,B.right);
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }