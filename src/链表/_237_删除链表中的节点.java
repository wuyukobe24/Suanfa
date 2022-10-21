package 链表;
// 
public class _237_删除链表中的节点 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    /*
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
       返回删除后的链表的头节点。
       [4,5,1,9]
       9
     **/
    public ListNode deleteNode1(ListNode head, int val) {
    	if (head == null) return null;
		ListNode newNode = new ListNode(0);
		newNode.next = head;
		head = newNode;
    	while (newNode.next != null) {
    		if (newNode.next.val == val) {
    			newNode.next = newNode.next.next;
    			break;
			}
    		newNode = newNode.next;
		}
    	return head.next;
    }
}
