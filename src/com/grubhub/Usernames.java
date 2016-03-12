package com.grubhub;

import java.util.LinkedHashMap;

public class Usernames {
	private LinkedHashMap<String, Object> people = new LinkedHashMap<String, Object>();
	public void insert(String username, Object o) {
		people.put(username, new Object());
	}
	public LinkedHashMap<String, Object> getPeople() {
		return people;
	}
}
