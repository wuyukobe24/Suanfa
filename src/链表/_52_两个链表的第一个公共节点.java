package 链表;

import 链表._237_删除链表中的节点.ListNode;

public class _52_两个链表的第一个公共节点 {
	public static void main(String[] args) {
		
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
	/*
	 * 输入两个链表，找出它们的第一个公共节点。
	 * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
			A = A == null ? headB : A.next;
			B = B == null ? headA : B.next;
		}
    	return A;
    }
}
