package src.main.java.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestSum {

	/*
	 * Check array of integer whether it contains combinations of elements that's sum equals to an integer target
	 * Return one best combination if exist
	 * Return null if there is no any combination
	 * https://youtu.be/oBt53YbR9Kk?t=6735
	 */
	
	static List<Integer> bestSum(int targetSum, int[] numbers) {
		return bestSum(targetSum, numbers, new HashMap<Integer, ArrayList<Integer>>());
	}

	private static List<Integer> bestSum(int targetSum, int[] numbers, HashMap<Integer, ArrayList<Integer>> memo) {
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		
		if (targetSum == 0) return new ArrayList<Integer>();
		
		if (targetSum < 0) return null;
		
		ArrayList<Integer> bestCombination = null;
		
		for (int num : numbers) {
			int targetSumLeft = targetSum - num;
			List<Integer> useThisNumResult = bestSum(targetSumLeft, numbers, memo);
			if (useThisNumResult != null) {
				ArrayList<Integer> totalResult = new ArrayList<Integer>(useThisNumResult);
				totalResult.add(num);

				if (bestCombination == null || totalResult.size() < bestCombination.size()) {
					bestCombination = totalResult;
				}
					
			}
		}
		
		memo.put(targetSum, bestCombination);
		return bestCombination;
	}
	
	public static void main(String[] args) {
		System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
		System.out.println(bestSum(8, new int[]{2, 3, 5}));
		System.out.println(bestSum(8, new int[]{1, 4, 5}));
		System.out.println(bestSum(100, new int[]{1, 2, 5, 25}));
		System.out.println(bestSum(100, new int[]{3, 9, 15}));
	}
	
}
