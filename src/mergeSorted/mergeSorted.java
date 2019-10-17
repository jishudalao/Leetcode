package mergeSorted;

import java.util.Arrays;

public class mergeSorted {
	public static void main(String[] args) {
	    int[] nums = {6, 5, 3, 8, 1, 7, 2, 9, 4};
	    segment(nums, 0, nums.length - 1);
	    System.out.println(Arrays.toString(nums));
	}

	/**
	 * �ݹ��зִ���
	 *
	 * @param nums  ���з�����
	 * @param left  ���з�����һ��Ԫ�ص�����
	 * @param right ���з��������һ��Ԫ�ص�����
	 */
	private static void segment(int[] nums, int left, int right) {
	    if (left < right) {
	        // �ҳ��м�����
	        int center = (left + right) / 2;
	        // �����������еݹ�
	        segment(nums, left, center);
	        // ���ұ�������еݹ�
	        segment(nums, center + 1, right);
	        // �ϲ�
	        merge(nums, left, center, right);
	    }
	}

	/**
	 * �����鲢�ź�������飨2·�鲢��
	 *
	 * @param nums   �������������
	 * @param left   �������ĵ�һ������
	 * @param center ����������һ��������center + 1������ĵ�һ������
	 * @param right  ����������һ������
	 */
	private static void merge(int[] nums, int left, int center, int right) {
	    int[] tmpArray = new int[right - left + 1];
	    int leftIndex = left;   //�������һ��Ԫ�ص�����
	    int rightIndex = center + 1;   //�������һ��Ԫ������
	    int tmpIndex = 0;    //��ʱ��������

	    // �ѽ�С�������Ƶ���������
	    while (leftIndex <= center && rightIndex <= right) {
	        if (nums[leftIndex] <= nums[rightIndex]) {
	            tmpArray[tmpIndex++] = nums[leftIndex++];
	        } else {
	            tmpArray[tmpIndex++] = nums[rightIndex++];
	        }
	    }

	    // �����ʣ�������������
	    while (leftIndex <= center) {
	        tmpArray[tmpIndex++] = nums[leftIndex++];
	    }

	    // ���ұ߱�ʣ�������������
	    while (rightIndex <= right) {
	        tmpArray[tmpIndex++] = nums[rightIndex++];
	    }

	    // ���������е�������nums����
	    /*for (int i = 0; i < tmpArray.length; i++) {
	        nums[begin + i] = tmpArray[i];
	    }*/
	    //�����Ż��������д��
	    System.arraycopy(tmpArray, 0, nums, left, tmpArray.length);
	}
}
