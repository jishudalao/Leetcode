package leetcode92;

public class Leetcode92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode die = new ListNode(-1);
		die.next = head;
		ListNode left = die;
		for(int i=0;i<m-1;i++) {
			left = left.next;
		}
		ListNode right = left.next;
		for(int i=0;i<n-m;i++) {
			ListNode cha = right.next;
			right.next = right.next.next;
			cha.next = left.next;
			left.next = cha;
		}
		return die.next;
    }
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }