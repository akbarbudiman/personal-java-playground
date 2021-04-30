package src.main.java.array;

import java.util.List;
import java.util.Map;

public class CountItemsMatchingRule {

//	https://leetcode.com/problems/count-items-matching-a-rule/
	
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> ruleMeaning = Map.of(
        		"type", 0,
        		"color", 1,
        		"name", 2
        );
        int indexToCompare = ruleMeaning.get(ruleKey);
        int result = 0;
        for (List<String> item : items) {
            if (item.get(indexToCompare).equals(ruleValue)) {
                result = result + 1;
            }
        }
        return result;
    }
	
}
