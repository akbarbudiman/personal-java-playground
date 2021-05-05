package src.main.java.dynamicprogramming.tabulation;

public class FibonacciTabulation {

	/*
	 * 3:10:54
	 * https://youtu.be/oBt53YbR9Kk
	 */
	
	public static long getFibonacciNumber(long index) {
		if (index == 0) return 0;
		else if (index == 1) return 1;
		
		long[] table = new long[(int) index];
		table[1] = 1;
		
		for (int i = 1 ; i < index - 2 ; i = i + 1) {
			table[i + 1] += table[i];
			table[i + 2] += table[i]; 
		}
		
		table[(int) (index-1)] += table[(int) (index-2)];
		return table[(int) (index-1)];
	}
	
	public static long getFibonacciNumberOther(long index) {
		if (index == 0) return 0;
		else if (index == 1) return 1;
		
		long[] table = new long[(int) index + 1]; // give extra one space
		table[1] = 1;
		
		for (int i = 1 ; i < index - 1 ; i = i + 1) { // to help loop bound
			table[i + 1] += table[i];
			table[i + 2] += table[i]; 
		}
		
		return table[(int) (index-1)];
	}
	
	public static void main(String[] args) {
		System.out.println(getFibonacciNumber(0));
		System.out.println(getFibonacciNumber(1));
		System.out.println(getFibonacciNumber(2));
		System.out.println(getFibonacciNumber(7));
		System.out.println(getFibonacciNumber(8));
		System.out.println(getFibonacciNumber(9));
		System.out.println(getFibonacciNumber(51));
	}
	
}
