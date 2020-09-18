package leetcode86;

import java.util.List;

public class Partition {
	public ListNode partition(ListNode head, int x) {
		ListNode beforeFix = new ListNode(0);
		ListNode before = beforeFix;
		ListNode afterFix = new ListNode(0);
		ListNode after = afterFix;
		while(head!=null) {
			if(head.val<x) {
				before.next = head;
				before = before.next;
			}
			else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		after.next = null;
		before.next = afterFix.next;
		return beforeFix.next;
    }
	public static void main(String[] args) {
		
	}
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }