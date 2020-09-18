package leetcode1538;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {
	//��������ⷨ
	/*
	public static int[] getLeastNumbers(int[] arr, int k) {
		if(k==0||arr.length==0) {
			return new int[0];
		}
		return quickSearch(arr,0,arr.length-1,k-1);
    }
	private static int[] quickSearch(int[] arr, int lo, int hi, int k) {
		// TODO Auto-generated method stub
		int j = partition(arr,lo,hi);
		if(j==k) {
			return Arrays.copyOf(arr, k+1);
		}
		else {
			return j > k ? quickSearch(arr, lo, j-1, k) : quickSearch(arr, j+1, hi, k);
		}
	}
	private static int partition(int[] arr, int lo, int hi) {
		// TODO Auto-generated method stub
		int vo = arr[lo];
		int i = lo, j = hi + 1;
		while(true) {
			while(++i <=hi && arr[i] < vo);
			while(--j >=lo && arr[j] > vo);
			if(i >=j) {
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		arr[lo] = arr[j];
		arr[j] = vo;
		return j;
	}
	public static void main(String[] args) {
		int arr[] = {4,5,1,6,2,7,3,8};
		int k = 4;
		System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
		
	}*/
	//����������
	
	
    public static void sort(int []arr){
        //1.�����󶥶�
        for(int i=arr.length/2-1;i>=0;i--){
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            adjustHeap(arr,i,arr.length);
        }
        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//���Ѷ�Ԫ����ĩβԪ�ؽ��н���
            adjustHeap(arr,0,j);//���¶Զѽ��е���
        }

    }

    /**
     * �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ�
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//��ȡ����ǰԪ��i
        for(int k=i*2+1;k<length;k=k*2+1){//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
            if(k+1<length && arr[k]<arr[k+1]){//������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;
            }
            if(arr[k] >temp){//����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//��tempֵ�ŵ����յ�λ��
    }

    /**
     * ����Ԫ��
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
	
	//������ⷨ
	public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // Ĭ����С���ѣ�ʵ�ִ������Ҫ��дһ�±Ƚ�����
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        
        // ���ض��е�Ԫ��
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }
	public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1,10,12};
        
        /*sort(arr);
        System.out.println(Arrays.toString(arr));*/
        System.out.println(Arrays.toString(getLeastNumbers(arr, 5)));
    }
	
}
