package src.main.java.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

	/*
	 * 2:38:40
	 * https://youtu.be/oBt53YbR9Kk
	 */
	
	public static int countConstruct(String target, String[] wordBank) {
		return countConstruct(target, wordBank, new HashMap<String, Integer>());
	}
	
	public static int countConstruct(String target, String[] wordBank, Map<String, Integer> memo) {
		int targetLen = target.length();
		if (targetLen == 0) return 1;
		if (memo.get(target) != null) return memo.get(target);
		
		int totalWayResult = 0;
		for (String prefix : wordBank) {
			if (target.indexOf(prefix) == 0) {
				int thisWayResult = countConstruct(target.substring(prefix.length()), wordBank, memo);
				totalWayResult = totalWayResult + thisWayResult;
			}
		}
		memo.put(target, totalWayResult);
		return totalWayResult;
	}
	
	public static void main(String[] args) {
		System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
		System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", 
				new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
										new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
	}
	
}
