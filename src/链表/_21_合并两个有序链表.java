package 链表;

public class _21_合并两个有序链表 {
	public static void main(String[] arges) {
		System.out.println("123");
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode newNode = new ListNode();
		ListNode head = newNode; 
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				head = head.next;
				l1 = l1.next;
			} else {
				head.next = l2;
				head = head.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			head.next = l2;
		} else {
			head.next = l1;
		}
		return newNode.next;
    }
}
