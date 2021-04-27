package src.main.java.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;

public class IsAnagramChecker {

	public static boolean isAnagram(String str1, String str2) {
		char[] char1 = str1.toCharArray();
		Arrays.sort(char1);
		String sorted1 = new String(char1);
		
		char[] char2 = str1.toCharArray();
		Arrays.sort(char2);
		String sorted2 = new String(char2);
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("abc");
		array.size();
		
		return sorted1.equals(sorted2);
	}
	
	public static boolean isAnagramWithoutSorting(String str1, String str2) {
		int[] char1 = new int[26];
		for (char c : str1.toCharArray()) {
			char1[c - 'a']++;
		}
		
		int[] char2 = new int[26];
		for (char c : str2.toCharArray()) {
			char2[c - 'a']++;
		}
		
		for (int i=0 ; i<26 ; i++) {
			if (char1[i] != char2[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagramWithoutSorting("abbc", "cbba"));
		System.out.println(isAnagramWithoutSorting("abc", "def"));
		System.out.println(isAnagramWithoutSorting("abc", "cde"));
	}
}
