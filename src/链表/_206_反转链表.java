package 链表;



// https://leetcode-cn.com/problems/reverse-linked-list/
public class _206_反转链表 {
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
	// 1、递归
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newNode;
    }
	// 2、迭代
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newNode = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newNode;
			newNode = head;
			head = tmp;
		}
		return newNode;
    }
	
	// 复习
	   public ListNode reverseList1(ListNode head) {

	    	if (head == null || head.next == null) return head;
	    	ListNode newNode = reverseList1(head);
	    	head.next.next = newNode;
	    	head = null;
	    	return newNode;
	    }
	
	// 2022.2.15
	public ListNode reverseList4(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = reverseList4(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	
	public ListNode reverseList3(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newhead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newhead;
			newhead = head;
			head = tmp;
		}
		return newhead;
	}
	

	public ListNode reverseList5(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseList5(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	
	
	

}
