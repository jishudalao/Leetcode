package leetcode21;

public class MergeTwoLists {
	/*
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
	*/
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
	
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		
		int len = lists.length;
		int index = 0;
		while(index<len) {
			pre = mergeTwoLists(pre, lists[index]);
			index++;
		}
		return pre.next;
	}
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l = mergeTwoLists(l1, l2);
		while(l!=null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
}

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 