package 链表;

import java.util.ArrayList;
import java.util.List;

public class _62_圆圈中最后剩下的数字 {
	public static void main(String[] args) {
		System.out.println(lastRemaining(5, 3));
	}
	/*
	 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
	 * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
	 * 求出这个圆圈里剩下的最后一个数字。
	 * 
	 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
	 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
	 * 
	 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
	 * */
	public static int lastRemaining(int n, int m) {
		ArrayList<Integer> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int index = 0;
		while (n>1) {
			index = (index+m-1)%n;
			list.remove(index);
			n--;
		}
		return list.get(0);
	}
	
	
	/*
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
    public int lastRemaining(int n, int m) {
    	ListNode Head = new ListNode(0, null);
    	ListNode tmp = Head;
    	for (int i = 1; i < n; i++) {
			if (i==n-1) {
				tmp.next = Head;
			} else {
				tmp.next = new ListNode(i, null);
				tmp = tmp.next;
			}
		}
    	int index = 0;
    	while (Head.next != null) {
    		index++;
    		if(index == m) {
    			Head.next = Head.next.next;
    			index = 1;
    		} else {
    			Head = Head.next;
    		}
		}
    	return Head.val;
    }
    */
	
}
