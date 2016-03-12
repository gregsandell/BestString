package com.grubhub;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class TestBestString extends TestCase {
	BestString bestString;
	@Before
	protected void setUp()  {
		 bestString = new BestString();
	}
	/**
	 * String with fewest digits wins.
	 */
	@Test
	public void testStringWithFewestDigits() {
		String[] testStrings = {"sdflk56l;kasdf3", "123dgfhghk567", "&^%r5df01", "  06tgdb"};		
		assertEquals("  06tgdb", bestString.getBestString(testStrings));
	}
	/**
	 * For two strings with same # of digits, the longer string should win.
	 */
	@Test
	public void testTwoUnequalLengthEqualDigitsStrings() {
		String[] testStrings = {"123dgfhghk567", "sdflk56l;kasdf3", "&^%rdf01", "  06tgdbg"};		
		assertEquals("  06tgdbg", bestString.getBestString(testStrings));
	}
	/**
	 * For two strings of same length and same # of digits, the first one should win.
	 */
	@Test
	public void testTwoEqualLengthEqualDigitsStrings() {
		String[] testStrings = {"123dgfhghk567", "sdflk56l;kasdf3", "&^%rdf01", "  06t db"};		
		assertEquals("&^%rdf01", bestString.getBestString(testStrings));
	}
	/**
	 * String with no digits has the fewest digits, thus the winner.
	 */
	@Test
	public void testStringWithNoDigits() {
		String[] testStrings = {"sdflk56l;kasdf3", "&^%rdf", "123dgfhghk567", "  06tgdb"};		
		assertEquals("&^%rdf", bestString.getBestString(testStrings));
	}
	/**
	 * If only one string, automatic winner regardless of content.
	 */
	@Test
	public void testOneString() {
		String[] testStrings = {"123dgfhghk567"};		
		assertEquals("123dgfhghk567", bestString.getBestString(testStrings));
	}
	/** 
	 * An empty string has zero digits, thus the winner.
	 */
	@Test
	public void testOneEmptyString() {
		String[] testStrings = {"  06tgdb", "123dgfhghk567", "sdflk56l;kasdf3", "", "&^%r5df01"};		
		assertEquals("", bestString.getBestString(testStrings));
	}
	/**
	 * Between an empty string and a string with no digits, the longer should win.
	 */
	@Test
	public void testStringWithNoDigitsVsBlankString() {
		String[] testStrings = {"123dgfhghk567", "", "&^%rdf", "  06tgdb"};		
		assertEquals("&^%rdf", bestString.getBestString(testStrings));
	}
	/**
	 * If two strings of same length with no digits, first should win
	 */
	@Test
	public void testTwoEqualLengthStringsWithNoDigits() {
		String[] testStrings = {"123dgfhghk567", "abc", "def", "  06tgdb"};		
		assertEquals("abc", bestString.getBestString(testStrings));
	}
	/**
	 * Only a null string, nobody is the winner.  Null.
	 */
	@Test
	public void testOneNullString() {
		String[] testStrings = {null};		
		assertNull(bestString.getBestString(testStrings));
	}
	/**
	 * No strings at all, nobody is the winner.  Null.
	 */
	@Test
	public void testNoStrings() {
		String[] testStrings = {};		
		assertNull(bestString.getBestString(testStrings));
	}
	/**
	 * After nulls are eliminated, make sure it still can deal with a single string.
	 */
	@Test
	public void testTwoNullStrings() {
		String[] testStrings = {null, "asdfg2"};		
		assertEquals("asdfg2", bestString.getBestString(testStrings));
	}
	/**
	 * Make sure one null string among real strings doesn't blow things up.
	 */
	@Test
	public void testNullStringIncludedString() {
		String[] testStrings = {null, "sdflk56l;kasdf3", "&^%r5df01", "  06tgdb"};		
		assertEquals("  06tgdb", bestString.getBestString(testStrings));
	}
}
