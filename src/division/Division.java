package division;

public class Division {
public static int divide(int dividend, int divisor) {
	int flag = 1;
	long dividends = dividend;
	long divisors = divisor;
	if((dividends<0&&divisors>0)||(dividends>0&&divisors<0)) {
		dividends = Math.abs(dividends);
		divisors = Math.abs(divisors);
		flag = -1;
	}else if (dividends<0&&divisors<0) {
		dividends = Math.abs(dividends);
		divisors = Math.abs(divisors);
	}
    long count = 0;    
    if(dividends == divisors) {
    	if(flag == 1)
    	{
    		return 1;
    	}else {
    		return -1;
    	}
    }
    
	while(dividends>=divisors) {
        	dividends = dividends - divisors;
        	count++;
        	
        }
	
	if(count>Integer.MAX_VALUE) {
		count = Integer.MAX_VALUE;
	}
	if(flag == -1) {
		count = 0 - count;
	}
	
	int c = (int)count;
	return c;
    }

public int divides(int dividend, int divisor) {
   if(dividend==0) {
	   return 0;
   }
   if(divisor==0) {
	   return -1;
   }
   if(dividend==Integer.MIN_VALUE&&divisor==-1) {
	   return Integer.MAX_VALUE;
   }
   boolean flag = (dividend^divisor)<0;
   int res = 0, count = 1;
   long dividend_temp= Math.abs((long)dividend);
   long divisor_temp= Math.abs((long)divisor);

   while(dividend_temp>=divisor_temp) {
	   res += count;
	   dividend_temp -= divisor_temp;
	   if(dividend_temp<Math.abs(divisor)) {
		   break;
	   }
	   if(dividend_temp-divisor_temp<divisor_temp) {
		   divisor_temp = Math.abs(divisor);
		   count = 1;
		   continue;
	   }
	   divisor_temp += divisor_temp;
	   count += count;
   }
   return flag?0-res: res;
}

public static void main(String[] args) {
	System.out.println(Integer.MAX_VALUE);
	System.out.println(divide(-2147483648,-1));
}
}
