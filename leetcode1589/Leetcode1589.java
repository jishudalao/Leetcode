package leetcode1589;

public class Leetcode1589 {
	//妈的老子真不知道怎么解了，逐个位数求解吧
	public static int countDigitOne(int n) {
		/*
		int o = 0, a = 1, b = 1;
        while(n > 0){
            o += (n + 8) / 10 * a;
            if(n % 10 == 1) o += b;
            b += n % 10 * a;
            a *= 10;
            n /= 10;
        }
        return o;
        */
		int count =0;
//    从个位开始统计
      for(int k=1; k<= n;k*=10){
          int cur = n / k;//摒弃以前计算过的位数
          int yu = cur % 10;//个位余数
          int removeNow = cur / 10;//除去本位
          count += removeNow * k;
          if(yu >1){
              count += k;
          }
          if(yu == 1){
              count += n % k +1;
          }
          if(removeNow == 0){
              break;
          }
      }
      return count;
    }
	public static void main(String[] args) {
		System.out.println(countDigitOne(247));
	}
}
