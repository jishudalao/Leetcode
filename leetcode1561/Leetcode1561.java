package leetcode1561;

public class Leetcode1561 {
	public ListNode getKthFromEnd(ListNode head, int k) {
		int len = 0;
		ListNode pre = head;
		while(pre!=null) {
			len++;
			pre = pre.next;
		}
		int res = len - k + 1;
		ListNode cur = new ListNode(-1);
		cur.next = head;
		for(int i=0;i<res;i++) {
			cur = cur.next;
		}
		return cur;
    }
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }