package 算法;

import java.util.HashMap;

class LRUCache2 {

	class DLinkedNode{
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
		DLinkedNode(){};
		DLinkedNode(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	private HashMap<Integer, DLinkedNode> dict = new HashMap<>();
	private int capacity;
	private int size;
	private DLinkedNode head, tail;
	// 使用双向链表和hashmap
    public LRUCache2(int capacity) {
    	this.capacity = capacity;
    	this.size = 0;
    	head = new DLinkedNode();
    	tail = new DLinkedNode();
    	head.next = tail;
    	tail.prev = head;
    }
    // 取数据
    public int get(int key) {
    	DLinkedNode node = dict.get(key);
    	if (node == null) return -1;
    	moveToHead(node);
    	return node.value;
    }
    
    // 存数据
    public void put(int key, int value) {
    	DLinkedNode node = dict.get(key);
    	if (node == null) {
			DLinkedNode newNode = new DLinkedNode(key, value);
			dict.put(key, newNode);
			addToHead(newNode);
			size++;
	    	if (size > capacity) {
				DLinkedNode tail = removeTail();
				dict.remove(tail.key);
				size--;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
    }
    // 添加到头部
    public void addToHead(DLinkedNode node) {
    	node.prev = head;
    	node.next = head.next;
    	head.next.prev = node;
    	head.next = node;
    }
    // 删除node
    public void removeNode(DLinkedNode node) {
    	node.next.prev = node.prev;
    	node.prev.next = node.next; 
    }
    // 移动到头部
    public void moveToHead(DLinkedNode node) {
		removeNode(node);
		addToHead(node);
	}
    // 删除尾部nodel
    public DLinkedNode removeTail() {
    	DLinkedNode node = tail.prev;
    	removeNode(node);
    	return node;
    }
}
