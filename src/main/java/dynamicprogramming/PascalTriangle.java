package src.main.java.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class PascalTriangle {
	
	
	static Map<Integer,Integer> factorialMapping;
	static {
		factorialMapping = new HashMap<>();
		factorialMapping.put(0, 1);
		factorialMapping.put(1, 1);
	}
	
	
	static Integer factorial(Integer number) {
		if (factorialMapping.containsKey(number)) return factorialMapping.get(number);
		else return number * factorial(number - 1);
	}
	
	
	static Integer combination(Integer n, Integer k) {
		if (k > n/2) return combination(n,(n-k));
		
		return factorial(n) / (factorial(k) * factorial(n-k));
		
	}

	
	static Integer[] createPascalTriangleLine(int lineNumber) {
		Integer[] result = new Integer[lineNumber];
		result[0] = 1;
		
		for (int index=0 ; index<=(lineNumber+1)/2 ; index++) {
			int thisElement = combination(lineNumber-1, index);
			result[index] = thisElement;
			result[lineNumber-index-1] = thisElement;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		int lineNumber = 7;
		
		Integer[] pascalTriangeLine = createPascalTriangleLine(lineNumber);
		
		for (Integer element : pascalTriangeLine) {
			System.out.print(element + " ");
		}
		
	}
	
}
