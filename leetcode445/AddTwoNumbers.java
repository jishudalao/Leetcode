package leetcode445;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();
		while(l1!=null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while(l2!=null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		int yu = 0;
		int num1 = 0;
		int num2 = 0;
		
		while(!s1.isEmpty()&&!s2.isEmpty()) {
			num1 = s1.pop();
			num2 = s2.pop();
			s3.push((num1+num2+yu)%10);
			yu = (num1+num2+yu)/10;
		}
		while(!s1.isEmpty()) {
			num1 = s1.pop();
			s3.push((num1+yu)%10);
			yu =(num1+yu)/10;
		}
		while(!s2.isEmpty()) {
			num2 = s2.pop();
			s3.push((num2+yu)%10);
			yu =(num2+yu)/10;
		}
		if(yu!=0) {
			s3.push(1);
		}
		ListNode dead = new ListNode(-1);
		ListNode pre = dead;
		while(!s3.isEmpty()) {
			pre.next = new ListNode(s3.pop());
			pre = pre.next;
		}
		
		return dead.next;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		addTwoNumbers(l1, l2);
	}
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }