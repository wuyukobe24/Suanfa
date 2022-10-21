package 链表;

public class _24_两两交换链表中的节点 {
	
	// 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
	// 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
	// https://leetcode-cn.com/problems/swap-nodes-in-pairs/
	
	public static void main(String[] args) {
		int[] nodes = {1,2,3,4};
//		System.out.println(swapPairs(nodes));
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newNode = new ListNode();
		newNode.next = head;
		ListNode cur = head;
		ListNode pri = newNode;
		while (cur != null && cur.next != null) {
			ListNode tmp = cur.next;
			cur.next = cur.next.next;
			tmp.next = cur;
			pri.next = tmp;
			pri = cur;
			cur = cur.next;
		}
		return newNode.next;
    }
}
