package leetcode61;

public class RotateRight {
	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||head.next==null) {
			return head;
		}
		int total = 1;
		ListNode pre = head;
		while(pre.next !=null) {
			pre = pre.next;
			total++;
		}
		ListNode die = new ListNode(-1);
		ListNode bianli = head;
		k = k % total;
		if(k==0) {
			return head;
		}
			for(int i=0;i<total-k-1;i++) {
				bianli = bianli.next;
			}
			die.next = bianli.next;
			bianli.next = null;
			pre.next = head;
		
		return die.next;

    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = rotateRight(head, 5);
		while(res.next!=null) {
			System.out.println(res.val);
			res = res.next;
		}
		System.out.println(res.val);
	}
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }