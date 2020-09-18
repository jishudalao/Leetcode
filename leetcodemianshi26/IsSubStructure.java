package leetcodemianshi26;

public class IsSubStructure {
	//�������������
	//��������Ҫ�Ƚ�B���Ƿ��Ƿ���a���ӽṹ,��һ���Ƕ�׼
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(A==null || B==null){
            return false;
        }
		//��һ�����ֿܷ�д����Ϊ�ֿ�д�����жϵ�ֻ��ͷ���ƥ�����²�ƥ������
		return subCheck(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean subCheck (TreeNode A, TreeNode B){
        //���BΪnull�����ʾƥ����ɣ�ֱ�ӷ���true
        if(B==null){
            return true;
        }
        //���AΪnull����ʱB��Ϊnull�� ���� A��ֵ������B��ֵ����ô��ƥ��ʧ�ܣ�ֱ�ӷ���false
        if(A==null || A.val!=B.val){
            return false;
        }
        //����ƥ��A����������B�������� && A����������B��������(�˴�Ϊand�Ĺ�ϵ��һ������false������ζ��ƥ��ʧ��)
        return subCheck(A.left,B.left)&&subCheck(A.right,B.right);
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }