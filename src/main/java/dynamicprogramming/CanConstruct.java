package src.main.java.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

	/*
	 * 2:12:47
	 * https://youtu.be/oBt53YbR9Kk?t=6735
	 */
	
	public static boolean canConstruct(String target, String[] wordBank) {
		return canConstruct(target, wordBank, new HashMap<String, Boolean>());
	}
	
	public static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {
		int targetLen = target.length();
		if (targetLen == 0) return true;
		if (memo.get(target) != null) return memo.get(target);
		
		for (String prefix : wordBank) {
			if (target.indexOf(prefix) == 0) {
				boolean result = canConstruct(target.substring(prefix.length()), wordBank, memo);
				memo.put(target, result);
				if (result == true) {
					return true;
				}
			}
		}
		
		memo.put(target, false);
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
										new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
	}
	
}
