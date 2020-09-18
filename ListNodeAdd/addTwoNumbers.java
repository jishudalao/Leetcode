package ListNodeAdd;

public class addTwoNumbers {
	public static ListNode addTwoNumbers (ListNode l1,ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = l1, q = l2, current = head;
		int carry = 0;
		while (p!=null || q!=null) {
			int x = (p != null)?p.val : 0;
			int y = (q != null)?q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			current.next = new ListNode(sum%10);
			current = current.next;
			if (p != null) p = p.next;
	        if (q != null) q = q.next;
	        
			
		}
		if(carry > 0) {
			current.next = new ListNode(carry);
		}
		return head.next;
	}
	
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(4);
		n4.next = n5;
		n5.next = n6;
		
		ListNode n7 = addTwoNumbers(n1,n4);
		System.out.println(n7.val+" "+n7.next.val+" "+n7.next.next.val);
	}
}
