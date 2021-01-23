package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

//	static Map<String, Boolean> savedCanSum;
//	static {
//		savedCanSum = new HashMap<>();
//	}
	
	static boolean canSum(int target, int[] numbers, int index) {
		if (target == 0) { 
			return true;
		}
		
		if (index == numbers.length) {
			return false;
		}
		
//		String key = target + "-" + index;
//		if (savedCanSum.containsKey(key)) {//			return savedCanSum.get(key);
//		}
		
		int num = numbers[index];
		int maxUsedOfNum = target / num;
		for (int used=0 ; used<=maxUsedOfNum ; used++) {
			int newTarget = target - (used * num);
			int newIndex = index + 1;
			boolean tryThisOne = canSum(newTarget, numbers, newIndex);
			if (tryThisOne == true) {
				return true;
			}
		}
		return false;
	}
	
	static boolean canSum(int target, int[] numbers) {
		return canSum(target, numbers, 0);
	}
	
	public static void main(String[] args) {
		int target = 30000;
		int[] numbers = {7, 15};
		System.out.println(canSum(target, numbers));
	}
	
}
