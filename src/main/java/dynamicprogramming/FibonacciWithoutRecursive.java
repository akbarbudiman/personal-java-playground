package src.main.java.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciWithoutRecursive {

	static Map<Long,Long> knownFibonacciNumbers;
	static {
		knownFibonacciNumbers = new HashMap<>();
		knownFibonacciNumbers.put((long)1, (long)1);
		knownFibonacciNumbers.put((long)2, (long)1);
	}
	
	static long getFibonacciNumberWithoutRecursive(long index) {
		if (knownFibonacciNumbers.containsKey(index)) {
			return knownFibonacciNumbers.get(index);
		}
		else {
			for (long i = 3 ; i <= index ; i++) {
				long twoIndexBefore = knownFibonacciNumbers.get(i - 2);
				long oneIndexBefore = knownFibonacciNumbers.get(i - 1);
			
				long thisIndexValue = twoIndexBefore + oneIndexBefore;
				knownFibonacciNumbers.put(i, thisIndexValue);
			}
			return knownFibonacciNumbers.get(index);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getFibonacciNumberWithoutRecursive(7));
		System.out.println(getFibonacciNumberWithoutRecursive(8));
		System.out.println(getFibonacciNumberWithoutRecursive(9));
		System.out.println(getFibonacciNumberWithoutRecursive(50));
	}
	
}
