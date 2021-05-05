package src.main.java.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class FIbonacciWithMemo {

	public static long getFibonacciNumber(long index) {
		Map<Long,Long> memo = new HashMap<>();
		memo.put((long)1, (long)1);
		memo.put((long)2, (long)1);
		return getFibonacciNumber(index, memo);
	}
	
	public static long getFibonacciNumber(long index, Map<Long,Long> memo) {
		if (memo.containsKey(index)) {
			return memo.get(index);
		}
		else {
			long twoIndexBefore = getFibonacciNumber(index - 2, memo);
			memo.put((long) (index - 2), twoIndexBefore);
			
			long oneIndexBefore = getFibonacciNumber(index - 1, memo);
			memo.put((long) (index - 1), oneIndexBefore);
			
			return  twoIndexBefore + oneIndexBefore;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getFibonacciNumber(7));
		System.out.println(getFibonacciNumber(8));
		System.out.println(getFibonacciNumber(9));
		System.out.println(getFibonacciNumber(50));
	}
	
}
