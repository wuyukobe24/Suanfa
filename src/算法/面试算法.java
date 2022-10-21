package 算法;

import java.util.HashMap;

public class 面试算法 {
	
	// 网易一面
	/*
	 * 获取字符串中所有重复出现的10个字符
	 * 输入 "AAAAACCCCCAAAAACCCCCAAAAAACTT",
	 * 输出 ["AAAAACCCCC",CCCCCAAAAA"]
	 * 
	 * 思路：for循环加滑动窗口双指针
	 * */

    // keep一面
   /* 编写一个方法, 实现查找字符串是否在另一个字符串中出现过:
    	字符串: ABABCABCDE
    	查找: ABCD
    	返回: YES
    	查找: ABCE
    	返回: NO
    	*/
    
//    public static void main(String[] args) {
//		System.out.println(resolve("ABABCABCDE", "ABCD"));
//	}
    public static boolean resolve(String str,String target) {
    	int count = target.length();
    	for (int i = 0; i < str.length()-count; i++) {
			String tmp = str.substring(i, i+count);
			System.out.println(tmp);
			if (tmp.equals(target)) {
				return true;
			}
		}
    	return false;
    }
    
 // -------------------------------------------------
    public static void main(String[] args) {
		System.out.println("123");
	}

	/*
	 * keep二面算法
	 */
	public class LinkedList {
		Node first;
		Node last;
		int size;
	}

	public class Node {
		Node prev;
		int element;
		Node next;
	}

	public void add(int index, int element) {
		LinkedList tmp = null;
		Node node = tmp.last;
		int ind = 0;
		while (node != null && index != ind) {
			node = node.next;
			ind++;
		}
		node.element = element;
		tmp.last = node;
	}
    
	// -------------------------------------------------
	/** UMU 一面
	 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
	 * 
	 * 输入：nums = [2,2,1,-1,1,2,2]
	 * 输出：2
	 * */
	
	public static int maxNum(int[] nums) {
		if (nums.length == 0) return 0;
		HashMap<Integer, Integer> dict = new HashMap<>();
		for (int num : nums) {
			if (dict.containsKey(num)) {
				dict.put(num, dict.get(num)+1);
			} else {
				dict.put(num, 1);
			}
		}
		int count = nums.length;
		for (int i = 0; i < count-1; i++) {
			for (int j = 0; j < count-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j+1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		int mid = count%2==0 ? count/2 : (count+1)/2;
		int res = nums[mid];
		if (dict.get(res)>mid) {
			return nums[mid];
		}
		return 0;
	}
    
	// -------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
