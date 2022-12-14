package 二叉树;

import java.util.Dictionary;
import java.util.HashMap;

public class _105_从前序与中序遍历序列构造二叉树 {

	// 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
	public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		 this.val = val;
		 this.left = left;
		 this.right = right;
		 }
	}
	
	private HashMap<Integer, Integer> dict;
	public TreeNode MyBuildTree(int[] preorder, int[] inorder, int p_left, int p_right, int i_left, int i_right) {
		if (p_left > p_right) return null;
		int p_root = p_left;
		int i_root = dict.get(preorder[p_root]);
		TreeNode root = new TreeNode(preorder[p_root]);
		int left_count = i_root - i_left;
		root.left = MyBuildTree(preorder, inorder, p_left+1, p_left+left_count, i_left, i_root-1);
		root.right = MyBuildTree(preorder, inorder, p_left+left_count+1, p_right, i_root+1, i_right);
		return root;
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	dict = new HashMap<Integer, Integer>();
    	int count = preorder.length;
    	for (int i = 0; i < count; i++) {
			dict.put(inorder[i], i);
		}
    	return MyBuildTree(preorder, inorder, 0, count-1, 0, count-1);
    }
    
    // 题解
    /*
    class Solution {
        private Map<Integer, Integer> indexMap;

        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);
            
            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }
    }
    */

}
