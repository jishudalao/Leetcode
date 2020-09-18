package leetcode1544;

import java.util.ArrayList;
import java.util.List;
public class ReversePrint {
	public int[] reversePrint(ListNode head) {
		List<Integer> res = new ArrayList<>();
		while(head!=null) {
			res.add(head.val);
			head = head.next;
		}
		int nums[] = new int[res.size()];
		for(int i=0;i<nums.length;i++) {
			nums[i] = res.get(res.size()-i-1);
		}
		return nums;
		
    }
	public static void main(String[] args) {
		
	}
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }