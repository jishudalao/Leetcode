package leetcode1095;

public class Leetcode1095 {
	/*
	public int findInMountainArray(int target, MountainArray mountainArr) {
        int ans = -1;
        int left=0;
        int right=mountainArr.length()-1;
        if(right<2)return -1;
        //  get the top point or the max number
        while(left<right){
            int mid = left+(right-left)/2;
            int midvla = mountainArr.get(mid);
            if(midvla>mountainArr.get(mid+1)) //  this is on right
                right=mid;
            else left=mid+1;    //  this is on left
        }
        ans = binary_search(0,left,target,mountainArr,true);
        if(ans!=-1)
            return ans;
        return binary_search(left,mountainArr.length(),target,mountainArr,false);
    }

    //  binary search target index
    //  order: indicate ascending or descending section (译：表明上升还是下降区间)
    public static int binary_search(int left, int right, int target, MountainArray mountainArray, boolean order){
        while(left<right){
            int mid = left+(right-left)/2;
            int midval = mountainArray.get(mid);
            if(midval==target)
                return mid;
            //   order为true无事为false时该判断取反（！）
            else if(order?midval<target:!(midval<target))
                left=mid+1;
            else right=mid;
        }
        return -1;
    }*/
}/*
interface MountainArray {
	      public int get(int index) {}
	      public int length() {}
	  }
	 */