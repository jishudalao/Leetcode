package leetcodemianshi36;

public class Leetcodemianshi36 {
	//��֪��Ϊʲô�ҿ���������ˣ����ǿ϶����������
	 Node head = null;
     Node pre = null;
	public Node treeToDoublyList(Node root) {
        if(root==null) {
        	return null;
        }
        backtrack(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

	private void backtrack(Node root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		backtrack(root.left);
		if(pre == null){
            head = root;
            pre = root;
        }else{                 //pre���ǿգ����ʾ���������У�pre�ǵ�ǰ�������Ľڵ�
            pre.right = root;
            root.left = pre;
            pre = root;
        }
		backtrack(root.right);
	}
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}