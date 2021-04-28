package src.main.java.string;

import java.util.HashSet;

// https://leetcode.com/problems/unique-email-addresses

public class NumUniqueEmail {

	public int numUniqueEmails(String[] emails) {
        HashSet<String> result = new HashSet<String>();
        for (String email : emails) {
        	String[] separatedEmail = email.split("@", 2);
        	String localName = separatedEmail[0];
        	String domainName = separatedEmail[1];
        	
        	String[] separatedLocalName = localName.split("\\+", 2);
        	String almostValidLocalName = separatedLocalName[0];
        	String validLocalName = almostValidLocalName.replace(".", "");
        	
        	String validEmail = validLocalName.concat("@").concat(domainName);
        	result.add(validEmail);
        }
        return result.size();
    }
		
}
