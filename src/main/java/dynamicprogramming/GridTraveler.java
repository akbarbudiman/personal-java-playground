package src.main.java.dynamicprogramming;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

	/*
	 * How many ways can you travel from top-left corner to bottom-right corner 
	 * in 2D grid with dimensions m * n where you can only move down or right
	 */
	
	public static BigDecimal gridTraveler(int m, int n) {
		return gridTraveler(m, n, new HashMap<String, BigDecimal>());
	}
	
	public static BigDecimal gridTraveler(int m, int n, Map<String, BigDecimal> memo) {
		if (m == 0 || n == 0) {
			return BigDecimal.ZERO;
		}
		else if (m == 1 || n == 1) {
			return BigDecimal.ONE;
		}
		else if (m < n) {
			return gridTraveler(n, m, memo);
		}
		else {
			String thisPoint = String.valueOf(m) + "," + String.valueOf(n);
			BigDecimal thisResult = memo.get(thisPoint);
			if (thisResult != null) {
				return thisResult;
			}
			
			BigDecimal totalWays = BigDecimal.ZERO;
			if (m > 1) {
				totalWays = totalWays.add(gridTraveler(m-1, n, memo));
			}
			if (n > 1) {
				totalWays = totalWays.add(gridTraveler(m, n-1, memo));
			}
			memo.put(thisPoint, totalWays);
			return totalWays;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(gridTraveler(1, 1));
		System.out.println(gridTraveler(2, 3));
		System.out.println(gridTraveler(3, 2));
		System.out.println(gridTraveler(3, 3));
		System.out.println(gridTraveler(18, 18));
	}
	
}
