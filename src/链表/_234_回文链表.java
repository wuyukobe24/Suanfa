package 链表;

import 链表._24_两两交换链表中的节点.ListNode;

public class _234_回文链表 {

	public static void main(String[] args) {
		
	}
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		// 快慢指针获取中间节点
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 反转后半部链表
		ListNode head2 = slow.next;
		// 获取前半部分链表
		slow.next = null;
		head2 = reverseList(head2);
		// 比较前后两部分(head长度大于等于head2，用head2判断，防止野指针)
 		while (head2 != null) {
			if (head.val != head2.val) {
				return false;
			}
			head = head.next;
			head2 = head2.next;
		}
		return true;
    }
	// 链表反转
	public ListNode reverseList(ListNode head) {
		ListNode pri = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pri;
			pri = cur;
			cur = tmp;
		}
		return pri;
	}
}
