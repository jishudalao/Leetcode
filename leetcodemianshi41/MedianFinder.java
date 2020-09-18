package leetcodemianshi41;

import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
	/*������������ж�����������ֵ��
	��ô��λ������������ֵ����֮��λ���м����ֵ���������
	�����ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��*/
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
