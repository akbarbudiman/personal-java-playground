package src.main.java.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllContruct {

	/*
	 * 2:47:32
	 * https://youtu.be/oBt53YbR9Kk
	 */
	
	public static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordBank) {
		if (target.equals("")) {
			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			result.add(new ArrayList<String>());
			return result;
		}
		return allConstruct(target, wordBank, new HashMap<String, ArrayList<ArrayList<String>>>());
	}
	
	public static ArrayList<ArrayList<String>> allConstructOther(String target, String[] wordBank) {
		return allConstructOther(target, wordBank, new HashMap<String, ArrayList<ArrayList<String>>>());
	}
	
	
	public static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordBank, Map<String, ArrayList<ArrayList<String>>> memo) {
		if (memo.get(target) != null) return memo.get(target);
		ArrayList<ArrayList<String>> allWay = new ArrayList<ArrayList<String>>();
		for (String prefix : wordBank) {
			if (target.equals(prefix)) {
				ArrayList<String> oneOfTheWay = new ArrayList<String>();
				oneOfTheWay.add(prefix);
				allWay.add(oneOfTheWay);
			}
			else if (target.indexOf(prefix) == 0) {
				ArrayList<ArrayList<String>> nextResult = allConstruct(target.substring(prefix.length()), wordBank, memo);
				for (ArrayList<String> subNextResult : nextResult) {
					ArrayList<String> oneOfTheWay = new ArrayList<String>();
					oneOfTheWay.add(prefix);
					oneOfTheWay.addAll(subNextResult);
					allWay.add(oneOfTheWay);
				}
			}
		}
		memo.put(target, allWay);
		return allWay;
	}
	
	
	public static ArrayList<ArrayList<String>> allConstructOther(String target, String[] wordBank, Map<String, ArrayList<ArrayList<String>>> memo) {
		if (memo.get(target) != null) return memo.get(target);
		if (target.length() == 0) {
			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			result.add(new ArrayList<String>());
			return result;
		}
		
		ArrayList<ArrayList<String>> allWay = new ArrayList<ArrayList<String>>();
		for (String prefix : wordBank) {
			if (target.indexOf(prefix) == 0) {
				ArrayList<ArrayList<String>> nextResult = allConstructOther(target.substring(prefix.length()), wordBank, memo);
				for (ArrayList<String> subNextResult : nextResult) {
					ArrayList<String> oneOfTheWay = new ArrayList<String>();
					oneOfTheWay.add(prefix);
					oneOfTheWay.addAll(subNextResult);
					allWay.add(oneOfTheWay);
				}
			}
		}
		memo.put(target, allWay);
		return allWay;
	}
	
	public static void main(String[] args) {
		System.out.println(allConstructOther("", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(allConstructOther("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
		System.out.println(allConstructOther("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
		System.out.println(allConstructOther("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
		System.out.println(allConstructOther("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
		System.out.println(allConstructOther("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
		System.out.println(allConstructOther("eeeeee", 
				new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
		System.out.println(allConstructOther("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
										new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
	}
	
}
