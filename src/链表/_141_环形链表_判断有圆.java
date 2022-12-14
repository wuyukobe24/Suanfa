package 链表;
// https://leetcode-cn.com/problems/linked-list-cycle/
public class _141_环形链表_判断有圆 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
			return false;
		}
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
			
        	if (slow == fast) return true;
        	slow = slow.next;
        	fast = fast.next.next;
		}
    	return false;
    }
}
