package leetcode1604;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1604 {
	//�Ҹ��㽲���������˸��Ӷȵ�Ҫ������ɶ�ľͲ�Ҫ���ˣ����϶�Ҫ��������
	//�����Ҳ�����������Ҫ��set��������������
	public int[] singleNumbers(int[] nums) {
		Set<Integer> set = new HashSet<>();
        for (int num : nums) {
        	if (!set.add(num)) {
            	set.remove(num);
            }
        }
        int res[] = new int[2];
        int count = 0;
            for(Integer s : set) {
            	res[count] = s;
            	count++;
            }
            return res;
    }
	public static void main(String[] args) {
		
	}
}
