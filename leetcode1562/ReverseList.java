package leetcode1562;

import java.util.ArrayList;
import java.util.List;
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		List<Integer> al = new ArrayList<>();
		while(head!=null) {
			al.add(head.val);
			head = head.next;
		}
		ListNode res = new ListNode(-1);
		ListNode res2 = res;
		for(int i = al.size()-1;i>=0;i--) {
			res.next = new ListNode(al.get(i));
			res = res.next;
		}
		return res2.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}