package leetcode876;

public class MiddleNode {
	public static ListNode middleNode(ListNode head) {
		if(head==null) {
			return null;
		}
		int count = 1;
		ListNode pre = head;
		while(pre.next!=null) {
			count++;
			pre = pre.next;
		}
		for(int i=0;i<count/2;i++) {
			head = head.next;
		}
		return head;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next =new ListNode(2);
		head.next.next =new ListNode(3);
		head.next.next.next =new ListNode(4);
		head.next.next.next.next =new ListNode(5);
		head.next.next.next.next.next =new ListNode(6);
		System.out.println(middleNode(head).val);
	}
}

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
