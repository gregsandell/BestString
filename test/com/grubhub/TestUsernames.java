package com.grubhub;

import java.util.LinkedHashMap;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class TestUsernames extends TestCase {
	private Usernames usernames;
	private String[] expectedNames = {"john", "paul", "george", "ringo"};
	@Before
	protected void setUp()  {
		usernames = new Usernames();
		usernames.insert(expectedNames[0], new Object());
		usernames.insert(expectedNames[1], new Object());
		usernames.insert(expectedNames[2], new Object());
		usernames.insert(expectedNames[3], new Object());
	}
	@Test
	public void testInsertionOrder() {
		LinkedHashMap<String, Object> people = usernames.getPeople();
		int count = 0;
		for (String name : people.keySet()) {
			assertEquals(expectedNames[count], name);
			++count;
		}
		
	}
}
