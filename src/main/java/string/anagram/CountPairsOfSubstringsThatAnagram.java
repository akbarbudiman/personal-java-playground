package string.anagram;

import java.util.ArrayList;

public class CountPairsOfSubstringsThatAnagram {

	public static int countPairOfSubstringsThatAnagram(String str) {
		int result = 0;
        
        for (int len = 1 ; len < str.length() ; len++) {
            ArrayList<String> subs = new ArrayList<>(); 
            for (int start = 0 ; start <= str.length() - len ; start++) {
                subs.add(str.substring(start, start+len));
            }
            
            for (int e1 = 0 ; e1 < subs.size() - 1 ; e1++) {
                for (int e2 = e1 + 1 ; e2 < subs.size() ; e2++) {
                    if (IsAnagramChecker.isAnagramWithoutSorting(subs.get(e1), subs.get(e2)))
                        result = result + 1;
                }
            }
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		System.out.println(countPairOfSubstringsThatAnagram("ifailuhkqq"));
		System.out.println(countPairOfSubstringsThatAnagram("kkkk"));
		
		// full testcase: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
	}
	
}
