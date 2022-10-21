package 链表;
/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

 * */

public class _22_链表中倒数第k个节点 {
	public static void main(String[] args) {
		
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
    public ListNode getKthFromEnd(ListNode head, int k) {
    	if (head == null) return null;
        if (head.next == null && k==1) return head;
    	ListNode tmpNode = head;
    	int num = 1;
    	int num2 = 1;
    	while (head.next != null) {
			num++;
			head = head.next;
		}
    	head = tmpNode;
    	if (num < k) return null;
    	if (num == k) return head;
    	while (head.next != null) {
			if (num2 == num-k) {
				return head.next;
			}
    		num2++;
			head = head.next;
		}
    	return null;
    }
}
