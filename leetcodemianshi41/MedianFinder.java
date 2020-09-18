package leetcodemianshi41;

import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
	/*如果从数据流中读出奇数个数值，
	那么中位数就是所有数值排序之后位于中间的数值。如果从数
	据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。*/
	PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    int count = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        count ++;
        maxQueue.add(num);
        minQueue.add(maxQueue.poll());
        if((count & 1) != 0)
            maxQueue.add(minQueue.poll());
        
    }
    
    public double findMedian() {
        if((count & 1) == 0){
            return (double)(maxQueue.peek() + minQueue.peek()) / 2;
        }else {
            return (double) maxQueue.peek();
        }
    }
}
