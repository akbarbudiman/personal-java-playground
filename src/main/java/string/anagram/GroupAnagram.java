package src.main.java.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strList) {
        if(strList == null || strList.length == 0) return Collections.emptyList();
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strList) {
            String key = convertToKeyFromOneStr(str);
            
            List<String> oneGroup = map.getOrDefault(key, new ArrayList<String>());
            oneGroup.add(str);
            map.put(key,oneGroup);
        }
        return new ArrayList<>(map.values());
    }
    
    private static String convertToKeyFromOneStr(String str) {
    	int[] thisOccurence = new int[26];
        for(int i = 0 ; i < str.length() ; i++){
        	thisOccurence[str.charAt(i) - 'a']++;
        }
        String key = Arrays.toString(thisOccurence);
        return key;
    }
    
    public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
		// full testcase: https://leetcode.com/problems/group-anagrams
	}
}
