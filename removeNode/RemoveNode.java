package removeNode;

public class RemoveNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 0;
		ListNode demmy = new ListNode(0);
		demmy.next = head;
		ListNode text = head;
		while(text!=null) {
			i++;
			text = text.next;
		}
		int reverseNum = i-n;
		text = demmy;
		while(reverseNum!=0) {
			text = text.next;
			reverseNum--;
		}
		text.next = text.next.next;
		return demmy.next;
	}
}

class ListNode{ 
	int val; 
	ListNode next; 
	ListNode(int val){ 
	this.val=val; 
	this.next=null; 
	} 
} 
