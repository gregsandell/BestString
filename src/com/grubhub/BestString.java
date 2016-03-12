package com.grubhub;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Parent class for getBestString utility.
 * @author greg
 *
 */
public class BestString {
	/**
	 * Compares Strings in an array, returns the String containing the least number of base 10 numeric characters.  
	 * If two Strings have the same number of numeric characters, returns the longest String.  
	 * If two Strings have the same number of numeric characters and are the same length, returns the String 
	 * that appears first in the input array.   If the array is empty, or consists of all nulls, returns null.  
	 * Strings having no numeric characters (including empty String) at all are first place contenders over Strings 
	 * having numeric characters.  Nulls are ignored when input consists of mixture of nulls and Strings.
	 * 
	 * @param values Strings to be compared
	 * @return The winning String
	 */
	public String getBestString(String[] values) {
	    String best = null;
		if (values != null && values.length != 0) {
			ArrayList<Candidate> c = new ArrayList<Candidate>();
			for (int i = 0; i < values.length; i++) {
				// compareTo() will choke on a null, suppress it
				if (values[i] == null) continue;
				c.add(new Candidate(values[i]));
			}
			if (c.size() > 0) {
				Collections.sort(c);
				best = c.get(0).value;
				if (c.size() > 1 && c.get(0).numberOfInts == c.get(1).numberOfInts 
						&& c.get(1).value.length() > c.get(0).value.length()) {
					best = c.get(1).value;
				}
			}
		}
	    return best;
	}
	// Hope you guys don't mind me introducing an inner class!  Allows me to do sorting.
	private class Candidate implements Comparable<Candidate> {
		int numberOfInts;
		String value;
		public Candidate(String value) {
			this.value = value;
			this.numberOfInts = value.replaceAll("[^0123456789]", "").length();
		}
		public int compareTo(Candidate p) {
			if (p == null) return 1;  
			return numberOfInts < p.numberOfInts ? -1 : (numberOfInts == p.numberOfInts ? 0 : 1);
		}
	}
}
