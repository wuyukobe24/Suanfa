package 算法;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

	/*
	 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
	 * 实现 LRUCache 类：
	 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
	 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
	 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
	 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
	 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
	 * 
	 * 输入
	 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
	 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
	 * 输出
	 * [null, null, null, 1, null, -1, null, -1, 3, 4]
	 * 
	 * 链接：https://leetcode.cn/problems/lru-cache
	 * */
	
	// 使用linkedList 和 hashmap
	private int capacity;
	private LinkedList<Integer> linkedList = new LinkedList<>();
	private HashMap<Integer, Integer> dict = new HashMap<>();
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    }
    // 取数据
    // 从map中获取数据value，为空返回-1；不为空，则链表移除该数据的key，并在尾部再次添加该数据的key，表示最新。同时返回获取的数据value。
    public int get(int key) {
    	final Integer value = dict.get(key);
    	if (value == null) return -1;
    	linkedList.remove((Object)key);
    	linkedList.addLast(key);
    	return value;
    }
    // 存数据
    // 1、链表中存在key，则删除对应的key，并重新添加，表示最新。同时map更新数据。直接返回
    // 2、如果此时链表数据已满（= capacity），则链表删除第一个（第一个表示最近最不活跃的）；map也删除链表中第一个数据key对应的value。
    // 3、最后，链表在尾部添加数据key。map也添加该数据。
    public void put(int key, int value) {
    	if (linkedList.contains(key)) {
    		linkedList.remove((Object)key);
        	linkedList.addLast(key);
        	dict.put(key, value);
        	return;
		}
    	if (linkedList.size() >= capacity) {
			Integer k =  linkedList.removeFirst();
			dict.remove(k);
		}
    	linkedList.addLast(key);
    	dict.put(key, value);
    }
}
