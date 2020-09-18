package leetcodemianshi59q2;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class MaxQueue {
	Queue<Integer> queue = null;
    public MaxQueue() {
    	queue = new ArrayDeque<>();
    }
    
    public int max_value() {
    	if(queue.peek()==null) {
    		return -1;
    	}
    	return Collections.max(queue);
    }
    
    public void push_back(int value) {
    	queue.offer(value);
    }
    
    public int pop_front() {
    	if(queue.peek()!=null) {
    	return queue.poll();
    	}
    	else {
    		return -1;
    	}
    }
}
