package leetcode23;



public class MergeKLists {
	public static ListNode mergeKLists(ListNode[] lists) {
		int len = lists.length;
		if(len==0) {
			return null;
		}
		if(len==1) {
			return lists[0];
		}if(len==2) {
			mergeTwoLists(lists[0], lists[1]);
		}
		int mid = len/2;
		ListNode[] left =new ListNode[mid]; 
		for(int i=0;i<mid;i++) {
			left[i] = lists[i];
		}
		
		ListNode[] right =new ListNode[len-mid];
		for(int i=mid,j=0;i<len;i++,j++) {
			right[j] = lists[i];
		}
		return mergeTwoLists(mergeKLists(left), mergeKLists(right));
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preNode = new ListNode(-1);
		ListNode outPut = preNode;
		preNode.next = outPut;
		while(l1!=null&&l2!=null) {
			if(l1.val<l2.val) {
				outPut.next = l1;
				l1 = l1.next;
			}
			else {
				outPut.next = l2;
				l2 = l2.next;
			}
			outPut = outPut.next;
		}
		if(l1==null) {
			outPut.next = l2;
		}
		if(l2==null){
			outPut.next = l1;
		}
		return preNode.next;
	}
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}