package leetcode1538;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {
	//快速排序解法
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
	//堆排序理论
	
	
    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
	
	//堆排序解法
	public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        
        // 返回堆中的元素
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
