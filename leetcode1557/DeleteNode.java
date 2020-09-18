package leetcode1557;

public class DeleteNode {
	public ListNode deleteNode(ListNode head, int val) {
		ListNode pre = new ListNode(-1);
		ListNode cur = pre;
		pre.next = head;
		while(cur!=null&&cur.next!=null) {
			if(cur.next.val==val) {
				cur.next = cur.next.next;
				break;
			}
			else {
				cur = cur.next;
			}
		}
		return pre.next;
    }
	public static void main(String[] args) {
		
	}
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
