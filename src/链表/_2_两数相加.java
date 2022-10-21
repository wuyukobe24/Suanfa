package 链表;

public class _2_两数相加 {
	
	/*
	 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
	 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
	 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 
	 * 链接：https://leetcode-cn.com/problems/add-two-numbers
	 * 
	 * 参考官方 https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
	 * */
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = null;
    	ListNode last = null;
    	int carry = 0;
    	while (l1!=null || l2!=null) {
			int a = l1!=null ? l1.val : 0;
			int b = l2!=null ? l2.val : 0;
			int sum = a+b+carry;
			carry = sum/10;
			if (head==null) {
				head = last = new ListNode(sum%10);
			} else {
				last.next = new ListNode(sum%10);
				last = last.next;
			}
			if (l1!=null) {
				l1 = l1.next;
			}
			if (l2!=null) {
				l2 = l2.next;
			}
		}
    	if (carry>0) {
			last.next = new ListNode(carry);
		}
    	return head;
    }
}
