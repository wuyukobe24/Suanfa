package 链表;

public class _19_删除链表的倒数第N个结点 {
	// 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
	// head = [1,2,3,4,5], n = 2
	// 输出：[1,2,3,5]
	public class ListNode{
		int val;
		ListNode next;
		ListNode(){
			
		}
		ListNode(int val, ListNode next){
			this.val = val;
			this.next = next;
		}
	}
	/* 2022.7.4
	 * 执行结果：通过显示详情添加备注
	 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
	 内存消耗：39.5 MB, 在所有 Java 提交中击败了58.40%的用户
	 通过测试用例：208 / 208
	 * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null || n==0) return head;
    	if (head.next == null && n==1) return null;
    	int count = 0;
    	ListNode newHead = head;
    	while (newHead != null) {
			count++;
			newHead = newHead.next;
		}
    	if (count < n) return head;
    	if (count == n) return head.next;
    	ListNode res = head;
    	int num = 0;
    	while (head != null) {
			num++;
			if (count-num == n) {
				head.next = head.next.next;
				break;
			}
			head = head.next;
		}
    	return res;
    }
}
