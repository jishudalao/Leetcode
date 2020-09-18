package leetcode1598;


public class GetIntersectionNode {
	
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	ListNode left = headA;
	ListNode right = headB;
	while(left!=right) {
		left = left ==null ? headB : left.next;
		right = right ==null ? headA : right.next;
	}
	return left;
    }

}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }