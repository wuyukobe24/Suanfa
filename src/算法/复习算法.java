package 算法;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.net.httpserver.Authenticator.Result;

import jdk.internal.jshell.tool.resources.l10n;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import 二叉树._144_二叉树的前序遍历.TreeNode;

public class 复习算法 {
	
	public static void main(String[] args) {
		System.out.println("nihao");
	}
	
	// 2022.2.15
	// 冒泡排序
	public static int[] maopao(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		return nums;
	}
	
	// 选择排序
	public static int[] select(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums;
	}
	
	// 快排
	public static int[] quickPort(int[] nums, int left, int right) {
		if (nums.length <= 1) {
			return nums;
		}
		int i = left;
		int j = right;
		int key = nums[i];
		while (i<j) {
			while (i<j && nums[j] > key) {
				j--;
			}
			nums[i] = nums[j];
			while (i<j && nums[i] < key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		quickPort(nums, left, i-1);
		quickPort(nums, i+1, right);
		return nums;
	}
	
	// 二分查找
	// 条件：⼆分查找针对的是有序数据.时间复杂度O(logn)
	public static int erfen(int[] nums, int target) {
		int i=0, j=nums.length-1;
		while (i<=j) {
			int mid = i+(j-i)/2;
			if (nums[mid] == target) {
				return nums[mid];
			} else if (nums[mid] > target) {
				j=mid-1;
			} else {
				i=mid+1;
			}
		}
		return 0;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode (int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	// 相同的树
	public static boolean isSametree(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		} else if (a.val != b.val) {
			return false;
		} else if (a == null || b == null) {
			return false;
		} else {
			return isSametree(a.left, b.left) && isSametree(a.right, b.right);
		}
	}
	
	// 对称二叉树
	public static boolean isDuiCheng(TreeNode root) {
		return DuiCheng(root, root);
	}
	public static boolean DuiCheng(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		} else {
			return a.val == b.val && DuiCheng(a.left, b.right) && DuiCheng(a.right, b.left);
		}
	}
	
	// 前序遍历
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preorder(root, list);
		return list;
	}
	public static void preorder(TreeNode tree, List<Integer> list) {
		if (tree == null) return;
		list.add(tree.val);
		preorder(tree.left, list);
		preorder(tree.right, list);
	}
	// 中序遍历
	public static List<Integer> zhongTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		zhong(root, list);
		return list;
	}
	public static void zhong(TreeNode tree, List<Integer> list) {
		if (tree == null) return;
		zhong(tree.left, list);
		list.add(tree.val);
		zhong(tree.right, list);
	}
	// 反转二叉树
	public static TreeNode fanzhaunTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		myfanzhaunTree(root);
		return root;
	}
	public static void myfanzhaunTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		myfanzhaunTree(root.left);
		myfanzhaunTree(root.right);
	}

	// 二叉树的层序遍历 
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<>();
    	if (root == null) return list;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while (!q.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int count = q.size();
			while (count > 0) {
				TreeNode node = q.poll();
				tmp.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				count--;
			}
			list.add(tmp);
		}
    	return list;
    }
    
    // 2022.2.16
    // 快排
    public static int[] qucikPort2(int[] nums, int left, int right) {
		int i=left;
		int j=right;
		int key=nums[i];
		while (i<j) {
			while (i<j && nums[j]>key) {
				j--;
			}
			nums[i] = nums[j];
			while (i<j && nums[i]<key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		qucikPort2(nums, left, i-1);
		qucikPort2(nums, i+1, right);
    	return nums;
	}
    
    // 链表反转
    public class NodeList {
		int val;
		NodeList next;
		NodeList(int val, NodeList next){
			this.val = val;
			this.next = next;
		}
	}
    public static NodeList reverseLink(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = null;
		while (head != null) {
			NodeList tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
    	return newHead;
	}
    
    public static NodeList reverseLink2(NodeList head) {
    	if (head == null || head.next == null) {
    		return head;
		}
    	NodeList newHead = reverseLink2(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
    
    // 2022.2.17
    // 冒泡
    public static int[] maopaoPort3(int[] nums) {
		if (nums.length <= 1) return nums;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
    	return nums;
	}
    // 选择
    public static int[] selectPort3(int[] nums) {
		if (nums.length <= 1) return nums;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums;
	}
    // 快排
    public static int[] quickPort3(int[] nums, int left, int right) {
		if (nums.length <= 1) return nums;
		int i = left, j = right;
		int key = nums[i];
		while (i<j) {
			while (i<j && nums[j] > key) {
				j--;
			}
			nums[i] = nums[j];
			while (i<j && nums[i] < key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		quickPort3(nums, left, i-1);
		quickPort3(nums, i+1, right);
    	return nums;
	}
    // 二分查找
    public static int erfenFind(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0, j = nums.length-1;
		while (i<j) {
			int mid = i+(j-1)/2;
			if (nums[mid] == target) {
				return nums[mid];
			} else if (nums[mid] > target) {
				j = mid-1;
			} else {
				i = mid+1;
			} 
		}
    	return 0;
	}
    
    // 链表反转
    // 迭代
    public static NodeList reverseNode3(NodeList head) {
		if (head == null || head.next == null) return head;
		NodeList newHead = null;
		while (head != null) {
			NodeList tmpList = head.next;
			head.next = newHead;
			newHead = head;
			head = tmpList;
		}
    	return newHead;
	}
    // 递归
    public static NodeList reverseNode4(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = reverseNode4(head.next);
		head.next.next = head;
		head.next = null;
    	return newHead;
	}
    // 47_礼物的最大价值
    public int maxValue(int[][] grid) {
    	int m=grid.length;
    	int n=grid[0].length;
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i==0 && j==0) {
					continue;
				} else if (i==0) {
					grid[i][j] += grid[i][j-1];
				} else if (j==0) {
					grid[i][j] += grid[i-1][j];
				} else {
					grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
				}
			}
		}
    	return grid[m-1][n-1];
    }
 
    // 丑数
    public int nthUglyNumber(int n) {
    	int[] res = new int[n+1];
    	res[1] = 1;
    	int x2 = 1, x3 = 1, x5 = 1;
    	for (int i = 2; i < n; i++) {
			int num = Math.min(Math.min(res[x2]*2, res[x3]*3), res[x5]*5);
			res[i] = num;
			if (res[x2]*2 == num) x2++;
			if (res[x3]*3 == num) x3++;
			if (res[x5]*5 == num) x5++;
		}
    	return res[n];
    }
    
    // 2022.2.18
    // 冒泡
    public static int[] maopao5(int[] nums) {
		if (nums.length <= 1) return nums;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
    	return nums;
	}
    // 选择
    public static int[] select5(int[] nums) {
    	if (nums.length <= 1) return nums;
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums;
	}
    // 快排
    public static int[] quick5(int[] nums, int left, int right) {
		if (nums.length <= 1) return nums;
		int i=left, j=right;
		int key=nums[i];
		while (i<j) {
			while (i<j && nums[j]>key) {
				j--;
			}
			nums[i] = nums[j];
			while (i<j && nums[i]<key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		quick5(nums, left, i-1);
		quick5(nums, i+1, right);
    	return nums;
	}
    
    // 二分
    public static int erfen5(int[] nums, int target) {
		int i = 0, j = nums.length-1;
		while (i<=j) {
			int mid = i+(j-1)/2;
			if (nums[mid] == target) {
				return nums[mid];
			} else if (nums[mid] > target) {
				j=mid-1;
			} else {
				i=mid+1;
			}
		}
    	return 0;
	}
    // 链表反转 迭代
    public static NodeList reverse5(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = null;
		while (head != null) {
			NodeList tmpList = head.next;
			head.next = newHead;
			newHead = head;
			head = tmpList;
		}
    	return newHead;
	}
    // 递归
    public static NodeList reverse6(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = reverse6(head.next);
		head.next.next = head;
		head.next = null;
    	return newHead;
	}
    
    // 2022.2.19
    // 冒泡
    public static int[] maopao6(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
    	return nums;
	}
    // 选择
    public static int[] select6(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
    	return nums;
	}
    // 快排
    public static int[] quick6(int[] nums, int left, int right) {
		if (nums.length <= 1) {
			return nums;
		}
		int i = left, j = right;
		int key = nums[i];
		while (i<j) {
			while (i<j && nums[j] > key) {
				j--;
			}
			nums[i] = nums[j];
			while (i<j && nums[i] < key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		quick6(nums, left, i-1);
		quick6(nums, i+1, right);
    	return nums;
	}
    // 二分
    public static int erfen6(int[] nums, int target) {
		int i = 0, j = nums.length-1;
		while (i<=j) {
			int mid = i+(j-1)/2;
			if (nums[mid] > target) {
				j = mid-1;
			} else if (nums[mid] < target) {
				i = mid+1;
			} else {
				return nums[mid];
			}
		}
    	return 0;
	}
    
    // 链表反转
    // 迭代
    public static NodeList reverse7(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = null;
		while (head != null) {
			NodeList tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
    	return newHead;
	}
    
    // 递归
    public static NodeList reverse8(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = reverse8(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
    
    // 二叉树
    // 前序遍历
    public static List<Integer> treeQianxu(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
    	myqianxu(root, list);
    	return null;
	}
    public static void myqianxu(TreeNode root,List<Integer> list) {
		if (root == null) return;
		list.add(root.val);
		myqianxu(root.left, list);
		myqianxu(root.right, list);
	}
    // 反转二叉树
    public static TreeNode fanzhuanTree(TreeNode tree) {
    	if (tree == null) {
			return tree;
		}
		myfanzhuantree(tree);
    	return tree;
	}
    public static void myfanzhuantree(TreeNode tree) {
		if (tree == null) return;
		TreeNode tmp = tree.left;
		tree.left = tree.right;
		tree.right = tmp;
		myfanzhuantree(tree.left);
		myfanzhuantree(tree.right);
	}
    // 相同的树
    public static boolean isSameTree2(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		} else if (tree1 == null || tree2 == null) {
			return false;
		} else {
			return tree1.val == tree2.val && isSameTree2(tree1.left, tree2.left) && isSameTree2(tree1.right, tree2.right);
		}
	}
    
    // 对称二叉树
    public static boolean jingxiangTree(TreeNode tree) {
		if (tree == null) {
			return true;
		}
    	return myjingxiangTree(tree, tree);
	}
    public static boolean myjingxiangTree(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		} else if (tree1 == null || tree2 == null) {
			return false;
		} else {
			return tree1.val == tree2.val && myjingxiangTree(tree1.left, tree2.right) && myjingxiangTree(tree1.right, tree2.left);
		}
	}
    
    // 2022.2.22
    
    // 冒泡
    public static int[] maopao9(int[] nums) {
		if (nums.length <= 1) return nums;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
    	return nums;
	}
    
    // 选择
    public static int[] select9(int[] nums) {
		if (nums.length <= 1) return nums;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
    	return nums;
	}

    // 快排
    public int[] quick9(int[] nums, int left, int right) {
		if (nums.length <= 1) return nums;
		int i=left, j=right;
		int key = nums[i];
		while (i<j) {
			while (i<j && nums[j] > key) {
				j--;
			}
			nums[i] = nums[j];
			while (i<j && nums[i] < key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		quick9(nums, left, i-1);
		quick6(nums, i+1, right);
    	return nums;
	}
    // 二分
    public static int erfen9(int[] nums, int target) {
    	int i=0, j=nums.length;
		while (i<=j) {
			int mid = i+(j-i)/2;
			if (nums[mid] == target) {
				return nums[mid];
			} else if (nums[mid] > target) {
				j = mid-1;
			} else {
				i = mid+1;
			}
		}
    	return 0;
	}
    
    // 链表反转 迭代
    public static NodeList reverse9(NodeList head) {
		if (head == null || head.next == null) return head;
		NodeList newHead = null;
		while (head != null) {
			NodeList tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}
    
    // 递归
    public static NodeList reverse29(NodeList head) {
		if (head == null || head.next == null) return head;
		NodeList newHead = reverse29(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
    // 相同二叉树
    public static boolean sameTree(TreeNode tree) {
    	return mysameTree(tree, tree);
	}
    public static boolean mysameTree(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		} else if (tree1 == null || tree2 == null) {
			return false;
		} else {
			return tree1.val == tree2.val && mysameTree(tree1.left, tree2.left) && mysameTree(tree1.right, tree2.right);
		}
	}
    
    // 对称二叉树
    
    // 反转二叉树
    public static void reverseTree9(TreeNode tree) {
		if (tree == null) return;
		TreeNode tmp = tree.left;
		tree.left = tree.right;
		tree.right = tmp;
		reverseTree9(tree.left);
		reverseTree9(tree.right);
	}
    
    // 2022.2.28
    // 冒泡
    public static int[] maopao28(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
    	return nums;
	}
    // 选择
    public static int[] select28(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
    	return nums;
	}
    // 快排
    public static int[] quick28(int[] nums, int left, int right) {
		if (nums.length <= 1) {
			return nums;
		}
		int i = left, j = right;
		int key = nums[i];
		while (i<j) {
			while (i<j && nums[j] > key) {
				j--;
			}
			nums[i] = nums[j];
			while (i<j && nums[i] < key) {
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		quick28(nums, left, i-1);
		quick28(nums, i+1, right);
    	return nums;
	}
    
    // 二分
    public static int erfen28(int[] nums, int target) {
		int i=0, j=nums.length-1;
		while (i<=j) {
			int mid = i+(j-1)/2;
			if (nums[mid] > target) {
				j=mid-1;
			} else if (nums[mid] < target) {
				i=mid+1;
			} else {
				return nums[mid];
			}
		}
    	return 0;
	}
    
    // 链表反转
    public static NodeList reverse28(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = null;
		while (head != null) {
			NodeList tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}
    public static NodeList reverse281(NodeList head) {
		if (head == null || head.next == null) {
			return head;
		}
		NodeList newHead = reverse281(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
    
    // 2022.6.29
    // 冒泡排序
    public static int[] maopao29(int[] nums) {
    	if (nums.length <= 1) {
			return nums;
		}
    	for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
    	return nums;
    }
    
    // 选择排序
    public static int[] select29(int[] nums) {
    	if (nums.length <= 1) {
			return nums;
		}
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
    	return nums;
    }
    
    // 快排
    public static int[] quickPort29(int[] nums, int left, int right) {
    	if (nums.length <= 1) {
			return nums;
		}
    	int i=left, j=right;
    	int key = nums[i];
    	while (i<j) {
			if (i<j && nums[j] > key) {
				j--;
			}
			nums[i] = nums[j];
			if (i<j && nums[i] < key) {
				i++;
			}
			nums[j] = nums[i];
		}
    	nums[i] = key;
    	quickPort29(nums, left, i-1);
    	quickPort29(nums, i+1, right);
    	return nums;
    }
    
    // 二分查找
    public static int erfenFind29(int[] nums, int target) {
    	int i=0, j=nums.length-1;
    	while (i<=j) {
			int mid = i+(j-1)/2;
			if (nums[mid] > target) {
				j = mid-1;
			} else if (nums[mid] < target) {
				i = mid+1;
			} else {
				return nums[mid];
			}
		}
    	return 0;
    }
    
    // 链表反转迭代
    public static NodeList reverse629(NodeList head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	NodeList newHead = null;
    	while (head != null) {
			NodeList tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
    	return newHead;
    }

    // 链表反转递归
    public static NodeList reverse6292(NodeList head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	NodeList newHead = reverse6292(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
    
    // 2022.6.30
    // 冒泡排序
    public static int[] maopao630(int[] nums) {
    	if (nums.length <= 1) {
			return nums;
		}
    	for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
    	return nums;
    }
    
    // 选择排序
    public static int[] select630(int[] nums) {
    	if (nums.length <= 1) {
			return nums;
		}
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
    	return nums;
    }
    
    // 快排
    public static int[] quickPort630(int[] nums, int left, int right) {
    	if (nums.length <= 1) {
			return nums;
		}
    	int i=left, j=right;
    	int key = nums[i];
    	while (i<j) {
			if (i<j && nums[j] > key) {
				j--;
			}
			nums[i] = nums[j];
			if (i<j && nums[i] < key) {
				i++;
			}
			nums[j] = nums[i];
		}
    	nums[i] = key;
    	quickPort630(nums, left, i-1);
    	quickPort630(nums, i+1, right);
    	return nums;
    }
    
    // 二分查找
    public static int erfenFind630(int[] nums, int target) {
    	int i=0, j=nums.length-1;
    	while (i<=j) {
			int mid = i+(j+1)/2;
			if (nums[mid] > target) {
				j=mid-1;
			} else if (nums[mid] < target) {
				i=mid+1;
			} else {
				return nums[mid];
			}
		}
    	return 0;
    }
    
    // 链表反转迭代
    public static NodeList reverse6301(NodeList head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	NodeList newHead = null;
    	while (head != null) {
			NodeList tmpList = head.next;
			head.next = newHead;
			newHead = head;
			head = tmpList;
		}
    	return newHead;
    }
    
    // 链表反转递归
    public static NodeList reverse6302(NodeList head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	NodeList newHead = reverse6302(head.next);
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
    

    
}
