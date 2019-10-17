package sumofthree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
public class demo {
	 public static List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		 List<Integer> oList = new ArrayList<Integer>();
	    for(int i=0;i<nums.length-2;i++) {
	    	
	    	for(int j=i+1;j<nums.length-1;j++) {
	    		
	    		for(int k=j+1;k<nums.length;k++) {
	    			if(nums[i]+nums[j]+nums[k]==0) {
		    			List<Integer> aList = new ArrayList<Integer>();
		    			if(nums[i]==nums[j]&&nums[i]==nums[k]&&nums[j]==nums[k]) {
		    				oList.add(0);
		    				oList.add(0);
		    				oList.add(0);
		    				break;
		    			
	    	        	}
		    			Iterator<List<Integer>> it_b=list.iterator();
		    			while(it_b.hasNext()){
		    	        	List<Integer> a=it_b.next();
		    	        	if(a.contains(nums[i])&&a.contains(nums[j])&&a.contains(nums[k])) {
		    	                it_b.remove();
		    	                
		    	                break;
		    	            }
		    	        }
		    			aList.add(nums[i]);
		    			aList.add(nums[j]);
		    			aList.add(nums[k]);
		    			list.add(aList);
		    			break;
		    		}
		    		
	    		}
	    		
	    		
	    		
	    	}
	    }    
	   
	    if(oList.contains(0)) {
	    	List<Integer> sList = new ArrayList<Integer>();
	    	sList.add(0);
			sList.add(0);
			sList.add(0);
	    	list.add(sList);
	    }
	    return list;
	    }
	 public static List<List<Integer>> threeSums(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		 
		 int length = nums.length;
		 if(length<3||nums==null) {
			 return list;
		 }
		 Arrays.sort(nums);
		 
		 for(int i=0;i<length;i++) {
			 if(nums[i]>0) {
				 break;
			 }
			 if(i>0&&nums[i]==nums[i-1]) {
				 continue;
			 }
			 int left = i+1;
			 int right = length-1;
			 while(left<right) {
				 int sum = nums[i]+nums[left]+nums[right];
				 if(sum==0) {
					 list.add(Arrays.asList(nums[i],nums[left],nums[right]));
					 while(left<right&&nums[left]==nums[left+1]) {
						 left++;//去重
					 }
					 while(left<right&&nums[right]==nums[right-1]) {
						 right--;//去重
					 }
					 left++;
					 right--;
				 }
				 else if(sum<0) {
					 left++;
				 }
				 else if(sum>0) {
					 right--;
				 }
			 }
		 }
		 return list;
	 }
	 
	
	 public static void main(String[] args) {
		
		int[] nums2 = {-1,0,1,2,-1,-4};
		 System.out.print("[");
		for(List<Integer> list : threeSums(nums2)) {
			System.out.print("[");
			for(int num : list) {
				System.out.print(num+",");
			}
			System.out.print("]");
		}
		System.out.print("]");
	}
}

