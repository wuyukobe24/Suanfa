package 算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 复习算法2 {

	public static void main(String[] args) {
		System.out.println(addsum(100));
	}
	
	// 递归函数
    static int sum = 0;
    public static int addsum(int n) {
		if (n == 1) return 1;
		sum = addsum(n-1);
		sum += n;
    	return sum;
	}
    
    // 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if (n==0) return;
    	for (int i = 0; i < n; i++) {
			nums1[m+i] = nums2[i];
		}
    	Arrays.sort(nums1);
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
    //  剑指 Offer II 023. 两个链表的第一个重合节点
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
    // 剑指 Offer 57. 和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Boolean> dict = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (dict.containsKey(key)) {
				return new int[] {key, nums[i]};
			}
			dict.put(nums[i], true);
		}
    	return null;
    }
    
    // 剑指 Offer II 025. 链表中的两数相加
    // 思路：参考两数之和，再进行链表反转
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	l1 = reverseList(l1);
    	l2 = reverseList(l2);
    	if (l1 == null) return l2;
    	if (l2 == null) return l1;
    	int carry = 0;
    	ListNode head = null;
    	ListNode last = null;
    	while (l1 != null || l2 != null) {
    		int a = l1 == null ? 0 : l1.val;
    		int b = l2 == null ? 0 : l2.val;
			int sum = a + b + carry;
			carry = sum/10;
			if (head == null) {
				head = last = new ListNode(sum%10, null);
			} else {
				last.next = new ListNode(sum%10, null);
				last = last.next;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			last.next = new ListNode(carry, null);
		}
		head = reverseList(head);
    	return head;
    }
    public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
    	return newHead;
	}
    // 剑指 Offer II 004. 只出现一次的数字 
    // 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    public int singleNumber(int[] nums) {
    	HashMap<Integer, Boolean> dict = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if (dict.containsKey(key)) {
				dict.put(key, true);
			} else {
				dict.put(key, false);
			}
		}
    	for (int i = 0; i < nums.length; i++) {
			if (dict.get(nums[i]) == false) {
				return nums[i];
			}
		}
    	return 0;
    }
    
    // 121. 买卖股票的最佳时机
    // 动态规划
    // 思路：一次遍历，每次记住买入最小值，用当前价格减去最小值，获取当前利润，和之前最大利润比较，取最大值即可。
    public static int maxProfit2(int[] prices) {
    	int cost = Integer.MAX_VALUE, prifit = 0;
    	for (int price : prices) {
			cost = Math.min(cost, price);
			prifit = Math.max(prifit, price-cost);
		}
    	return prifit;
    }
    // 53. 最大子数组和
    // 动态规划
    public int maxSubArray(int[] nums) {
    	int pri = 0, max = nums[0];
    	for (int num : nums) {
			pri = Math.max(pri+num, num);
			max = Math.max(max, pri);
		}
    	return max;
    }
}
