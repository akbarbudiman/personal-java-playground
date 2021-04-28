package src.main.java.string;

// https://leetcode.com/problems/longest-common-prefix

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
        String result = "";
        
        int index = 0;
        loop : while(true) {
            try {
                char c = strs[0].charAt(index);
                for (String str : strs) {
                	if (str.charAt(index) != c) break loop;
                }
                index = index + 1;
                result = result + Character.toString(c);
            }
            catch (IndexOutOfBoundsException e) {
            	break;
			}
            
        }
        
        return result;
    }
	
}
