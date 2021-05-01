package src.main.java.string;

import java.util.HashMap;

public class PrefixAndSuffixSearch {

/*
 * 	origin:
 * 	https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3728/
 * 	
 * 	from array of words, find the highest index of word in the words, 
 * 	which has the prefix prefix and the suffix suffix,
 * 	if there is no such word in the dictionary, return -1
 * 
 * 	function call:
 * 	PrefixAndSuffixSearch obj = new PrefixAndSuffixSearch(words);
 * 	int result = obj.f(prefix, suffix);
 *  
 *  the idea :
 *  create dictionary that store the highest index based on the prefix and the suffix from inserted words
 */
	
    private HashMap<String, HashMap<String, Integer>> dictionary;
    
    public PrefixAndSuffixSearch(String[] words) {
        this.dictionary = new HashMap<String, HashMap<String, Integer>>();
        int totalWordLen = words.length;
        
        for (int index = 0 ; index < totalWordLen ; index = index + 1) {
            String word = words[index];
            int thisWordLen = word.length();
            
            for (int preIdx = 1 ; preIdx <= thisWordLen ; preIdx = preIdx + 1) {
                for (int sufIdx = 1 ; sufIdx <= thisWordLen ; sufIdx = sufIdx + 1) {
                	String thisPrefix = word.substring(0, preIdx);
                    String thisSuffix = word.substring(thisWordLen - sufIdx);
                    
                    if (this.dictionary.get(thisPrefix) != null) {
                        this.dictionary.get(thisPrefix).put(thisSuffix, index);
                    }
                    else {
                        this.dictionary.put(thisPrefix, new HashMap<String, Integer>());
                        this.dictionary.get(thisPrefix).put(thisSuffix, index);
                    }
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        HashMap<String, Integer> suffixDict = this.dictionary.getOrDefault(prefix, null);
        if (suffixDict != null) {
            return suffixDict.getOrDefault(suffix, -1);
        }
        else {
            return -1;
        }
    }
}
