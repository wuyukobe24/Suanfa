package 链表;


import 链表._141_环形链表_判断有圆.ListNode;

public class _06_从尾到头打印链表 {
	public static void main(String[] args) {
		
	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
    public static int[] reversePrint(ListNode head) {
    	if (head == null || head.next == null) return null;
    	// 链表反转
    	ListNode newNode = null;
    	int count = 0;
    	while (head.next != null) {
        	count++;
        	ListNode tmp = head.next;
        	head.next = newNode;
        	newNode = head;
        	head = tmp;
		}
    	System.out.println(count);
    	int[] array = new int[count];
    	for (int i = 0; i < count; i++) {
        	System.out.println(newNode.val);
			array[i] = newNode.val;
			newNode = newNode.next;
		}
    	System.out.println(array);
    	return array;
    }
    
    // 递归反转链表
//    public static ListNode reverseNode(ListNode head) {
//		if (head == null || head.next == null) {
//			return head;
//		}
//		ListNode newNode = reverseNode(head.next); 	
//		head.next.next = newNode;
//		head.next = null;
//    	return head;
//	}
    
}
