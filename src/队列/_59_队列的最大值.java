package 队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _59_队列的最大值 {

	/*
	 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
	 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
	 * 若队列为空，pop_front 和 max_value 需要返回 -1

输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]

思路：为了实现此递减列表，需要使用 双向队列 ，假设队列已经有若干元素：

当执行入队 push_back() 时： 若入队一个比队列某些元素更大的数字 xx ，则为了保持此列表递减，需要将双向队列 尾部所有小于 xx 的元素 弹出。
当执行出队 pop_front() 时： 若出队的元素是最大元素，则 双向队列 需要同时 将首元素出队 ，以保持队列和双向队列的元素一致性。
使用双向队列原因：维护递减列表需要元素队首弹出、队尾插入、队尾弹出操作皆为 O(1)O(1) 时间复杂度。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * */

	Queue<Integer> queue;
	Deque<Integer> deque;
    public void MaxQueue() {
    	queue = new LinkedList<>();
    	deque = new LinkedList<>();
    }
    
    public int max_value() {
    	return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    
    public void push_back(int value) {
    	queue.offer(value);
    	while (!deque.isEmpty() && deque.peekLast() < value) {
			deque.pollLast();
		}
    	deque.offerLast(value);
    }
    
    public int pop_front() {
    	if (queue.isEmpty()) return -1;
    	if (queue.peek().equals(deque.peekFirst())) {
			deque.pollFirst();
		}
    	return queue.poll();
    }
}
