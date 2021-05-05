package src.main.java.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.List;

/*
 * Check array of integer whether it contains combinations of elements that's sum equals to an integer target
 * Return one combination if exist
 * Return null if there is no any combination
 * https://youtu.be/oBt53YbR9Kk?t=5373
 */

public class HowSum {
	
	public static void main(String[] args) {
		System.out.println(howSum(0, new int[] {1, 2, 3}));
		System.out.println(howSum(7, new int[] {8, 5, 3, 2}));
		System.out.println(howSum(8, new int[] {2, 3, 5}));
		System.out.println(howSum(7, new int[] {2, 4}));
		System.out.println(howSum(30, new int[] {7, 3, 9}));
		System.out.println(howSum(300, new int[] {7, 14}));
	}

	static List<Integer> howSum(int targetSum, int[] numbers) {
		return howSum(targetSum, numbers, 0, new ArrayList<Integer>());
	}
	
	static List<Integer> howSum(int targetSum, int[] numbers, int index, List<Integer> result) {
		if (targetSum == 0) {
			return result;
		}

		if (index == numbers.length) {
			return null;
		}
		
		int thisNumber = numbers[index];
		
		int maxUsageOfThisNumber = targetSum / thisNumber;
		
		for (int usage = maxUsageOfThisNumber ; usage >= 0 ; usage--) {
			int newTargetSum = targetSum - (thisNumber * usage);
			int newIndex = index + 1;
			
			List<Integer> tempResultIfUseThisNumber = new ArrayList<Integer>();
			tempResultIfUseThisNumber.addAll(result);
			for (int usageToResult = 0 ; usageToResult < usage ; usageToResult++) {
				tempResultIfUseThisNumber.add(thisNumber);
			}
			
			List<Integer> resultIfUseThisNumber = howSum(newTargetSum, numbers, newIndex, tempResultIfUseThisNumber);
			if (resultIfUseThisNumber != null) return resultIfUseThisNumber;
		}
		
		return null;
	}
	
}
