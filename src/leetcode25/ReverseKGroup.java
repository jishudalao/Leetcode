package leetcode25;

public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode end = dummy;
		while(end.next!=null) {
			for(int i=0;i<k&&end!=null;i++) {
				end = end.next;
			}
			if (end == null) break;
			ListNode start = pre.next;
			ListNode next = end.next;
			end.next = null;
			pre.next = reverse(start);
			start.next = next;
			pre = start;
			end = start;
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode start) {
		// TODO Auto-generated method stub
		ListNode pre = null;
		while(start!=null) {
			ListNode next = start.next;
			start.next = pre;
			pre = start;
			start = next;
		}
		return pre;
	}
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
